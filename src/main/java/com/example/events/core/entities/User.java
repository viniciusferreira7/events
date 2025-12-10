package com.example.events.core.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public record User(
        UUID id,
        String name,
        String email,
        LocalDateTime created_at
) {
}
