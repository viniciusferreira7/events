package com.example.events.core.entities;

import java.util.Date;

public record Event(
        String id,
        String authorId,
        EventType type,
        String name,
        String description,
        Date startTime,
        Date endTime,
        String local,
        Short capacity,
        Date createdAt,
        Date updatedAt
) {
}
