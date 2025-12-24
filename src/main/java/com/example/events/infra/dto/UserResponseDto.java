package com.example.events.infra.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Schema(description = "Response object containing complete user information")
public record UserResponseDto(
        @Schema(description = "Unique identifier of the user", example = "123e4567-e89b-12d3-a456-426614174000")
        UUID id,

        @Schema(description = "User's full name", example = "John Doe")
        String name,

        @Schema(description = "User's email address", example = "john.doe@example.com")
        String email,

        @Schema(description = "Timestamp when the user was created", example = "2024-12-13T08:00:00")
        LocalDateTime createdAt,

        @Schema(description = "List of events associated with the user")
        List<EventResponseDto> events
) {
}
