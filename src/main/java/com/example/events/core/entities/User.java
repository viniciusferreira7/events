package com.example.events.core.entities;

import com.example.events.infra.dto.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record User(
        UUID id,
        String name,
        String email,
        LocalDateTime created_at,
        List<EventDto> events
) {
}
