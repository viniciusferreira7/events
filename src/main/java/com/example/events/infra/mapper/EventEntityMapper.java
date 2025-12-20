package com.example.events.infra.mapper;

import com.example.events.core.entities.Event;
import com.example.events.infra.persistence.EventEntity;

import java.util.Optional;

public class EventEntityMapper {
    public static EventEntity toEntity(Event event){
        return new EventEntity(
                event.sponsorId(),
                event.identifier(),
                event.type(),
                event.name(),
                event.description(),
                event.location(),
                event.capacity(),
                event.startTime(),
                event.endTime()
        );
    }

    public static Event toDomain(EventEntity eventEntity){
        return new Event(
                eventEntity.getId(),
                eventEntity.getSponsorId(),
                eventEntity.getIdentifier(),
                eventEntity.getType(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getStartTime(),
                eventEntity.getEndTime(),
                eventEntity.getLocation(),
                eventEntity.getCapacity(),
                eventEntity.getCreatedAt(),
                Optional.of(eventEntity.getUpdatedAt())
        );
    }
}
