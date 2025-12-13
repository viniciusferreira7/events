package com.example.events.infra.dto;

import com.example.events.core.enums.EventType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder
@Schema(description = "Event data transfer object containing all event information")
public record EventDto(
        @Schema(description = "Unique identifier of the event sponsor", example = "123e4567-e89b-12d3-a456-426614174000")
        UUID sponsorId,

        @Schema(description = "Unique identifier for the event", example = "EVENT-2024-001")
        String identifier,

        @Schema(description = "Type of the event", example = "CONFERENCE", allowableValues = {
                "CONFERENCE", "SEMINAR", "WORKSHOP", "MEETUP", "NETWORKING",
                "LECTURE", "WEBINAR", "PANEL", "TALK", "BOOTCAMP",
                "HACKATHON", "TRAINING", "ROUND_TABLE", "SUMMIT", "FAIR"
        })
        EventType type,

        @Schema(description = "Name of the event", example = "Spring Boot Conference 2024")
        String name,

        @Schema(description = "Detailed description of the event", example = "Annual conference covering latest Spring Boot features and best practices")
        String description,

        @Schema(description = "Event start date and time", example = "2024-12-13T09:00:00")
        LocalDateTime startTime,

        @Schema(description = "Event end date and time", example = "2024-12-13T18:00:00")
        LocalDateTime endTime,

        @Schema(description = "Physical or virtual location of the event", example = "Convention Center, Hall A")
        String location,

        @Schema(description = "Maximum number of attendees", example = "500")
        Short capacity,

        @Schema(description = "Timestamp when the event was created", example = "2024-12-13T08:00:00")
        LocalDateTime createdAt,

        @Schema(description = "Timestamp when the event was last updated", example = "2024-12-13T10:00:00", nullable = true)
        Optional<LocalDateTime> updatedAt
) {
}
