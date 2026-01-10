package com.example.events.infra.presentation;

import com.example.events.core.entities.User;
import com.example.events.core.usecases.CreateUserUseCase;
import com.example.events.infra.dto.CreateUserRequestDto;
import com.example.events.infra.dto.UserResponseDto;
import com.example.events.infra.mapper.UserDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto userData){
        User userCreated = this.createUserUseCase.execute(UserDtoMapper.toDomain(userData));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserDtoMapper.toResponseDto(userCreated));
    }
}
