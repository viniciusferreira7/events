package com.example.events.core.entities;

import com.example.events.core.enums.EventType;

import java.time.LocalDateTime;
import java.util.Optional;

public record Event(
        String id,
        String sponsorId,
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
