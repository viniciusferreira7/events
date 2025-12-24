package com.example.events.infra.dto;

import com.example.events.core.enums.EventType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Schema(description = "Request object for creating a new event")
public record CreateEventRequestDto(
        @NotNull(message = "Sponsor ID is required")
        @Schema(description = "Unique identifier of the event sponsor", example = "123e4567-e89b-12d3-a456-426614174000", requiredMode = Schema.RequiredMode.REQUIRED)
        UUID sponsorId,

        @NotNull(message = "Event identifier is required")
        @Schema(description = "Unique identifier for the event", example = "EVENT-2024-001", requiredMode = Schema.RequiredMode.REQUIRED)
        String identifier,

        @NotNull(message = "Event type is required")
        @Schema(description = "Type of the event", example = "CONFERENCE", allowableValues = {
                "CONFERENCE", "SEMINAR", "WORKSHOP", "MEETUP", "NETWORKING",
                "LECTURE", "WEBINAR", "PANEL", "TALK", "BOOTCAMP",
                "HACKATHON", "TRAINING", "ROUND_TABLE", "SUMMIT", "FAIR"
        }, requiredMode = Schema.RequiredMode.REQUIRED)
        EventType type,

        @NotNull(message = "Event name is required")
        @Schema(description = "Name of the event", example = "Spring Boot Conference 2024", requiredMode = Schema.RequiredMode.REQUIRED)
        String name,

        @Schema(description = "Detailed description of the event", example = "Annual conference covering latest Spring Boot features and best practices")
        String description,

        @NotNull(message = "Start time is required")
        @Schema(description = "Event start date and time", example = "2024-12-13T09:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime startTime,

        @NotNull(message = "End time is required")
        @Schema(description = "Event end date and time", example = "2024-12-13T18:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
        LocalDateTime endTime,

        @NotNull(message = "Location is required")
        @Schema(description = "Physical or virtual location of the event", example = "Convention Center, Hall A", requiredMode = Schema.RequiredMode.REQUIRED)
        String location,

        @NotNull(message = "Capacity is required")
        @Schema(description = "Maximum number of attendees", example = "500", requiredMode = Schema.RequiredMode.REQUIRED)
        Short capacity
) {
}
