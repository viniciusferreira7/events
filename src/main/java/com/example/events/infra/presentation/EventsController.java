package com.example.events.infra.presentation;

import com.example.events.core.entities.Event;
import com.example.events.core.usecases.CreateEventUseCase;
import com.example.events.infra.dto.CreateEventRequestDto;
import com.example.events.infra.dto.EventResponseDto;
import com.example.events.infra.mapper.EventDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
@Tag(name = "Events", description = "Events management API")
public class EventsController {
    private final CreateEventUseCase createEventUseCase;

    @PostMapping
    @Operation(
            summary = "Create a new event",
            description = "Creates a new event with the provided information including sponsor, location, capacity and timing details"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Event created successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EventResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid event data provided",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody CreateEventRequestDto eventBody){
        Event event = EventDtoMapper.toDomain(eventBody);

        Event eventCreated = this.createEventUseCase.execute(event);

        return ResponseEntity.status(HttpStatus.CREATED).body(EventDtoMapper.toResponseDto(eventCreated));
    }

}
