package com.example.events.core.entities;

import com.example.events.core.enums.EventType;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public record Event(
        UUID id,
        UUID sponsorId,
        String identifier,
        EventType type,
        String name,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String location,
        Short capacity,
        LocalDateTime createdAt,
        Optional<LocalDateTime> updatedAt
) {
}
