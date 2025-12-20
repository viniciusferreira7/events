package com.example.events.infra.mapper;

import com.example.events.core.entities.Event;
import com.example.events.infra.dto.EventDto;

import java.util.UUID;

public class EventDtoMapper {
    public static Event toDomain(EventDto eventDTO){
        return new Event(
               UUID.randomUUID(),
                eventDTO.sponsorId(),
                eventDTO.identifier(),
                eventDTO.type(),
                eventDTO.name(),
                eventDTO.description(),
                eventDTO.startTime(),
                eventDTO.endTime(),
                eventDTO.location(),
                eventDTO.capacity(),
                eventDTO.createdAt(),
                eventDTO.updatedAt()
            );
    }

    public static EventDto toDto(Event event){
        return EventDto.builder()
                .sponsorId(event.sponsorId())
                .identifier(event.identifier())
                .type(event.type())
                .name(event.name())
                .description(event.description())
                .startTime(event.startTime())
                .endTime(event.endTime())
                .location(event.location())
                .capacity(event.capacity())
                .createdAt(event.createdAt())
                .updatedAt(event.updatedAt())
            .build();
    }
}
