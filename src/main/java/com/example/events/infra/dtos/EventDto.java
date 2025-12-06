package com.example.events.infra.dtos;

import com.example.events.core.enums.EventType;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Builder
public record EventDto(
        UUID sponsorId,
        String identifier,
        EventType type,
        String name,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String location,
        Short capacity
) {
}
