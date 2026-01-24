package events.infra.presentation;

import events.core.entities.User;
import events.core.exceptions.UserAlreadyExistsException;
import events.core.usecases.CreateUserUseCase;
import events.infra.dto.CreateUserRequestDto;
import events.infra.dto.ErrorResponseDto;
import events.infra.dto.UserResponseDto;
import events.infra.mapper.UserDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Users management API")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    @Operation(
            summary = "Create a new user",
            description = "Creates a new user with the provided information including name and email"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User created successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid user data provided",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "User with this email already exists",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDto userData){
        try {
            User userCreated = this.createUserUseCase.execute(UserDtoMapper.toDomain(userData));
            return ResponseEntity.status(HttpStatus.CREATED).body(UserDtoMapper.toResponseDto(userCreated));
        } catch (UserAlreadyExistsException e) {
            ErrorResponseDto errorResponse = new ErrorResponseDto(
                    e.getMessage(),
                    HttpStatus.CONFLICT.value()
            );
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
    }
}
