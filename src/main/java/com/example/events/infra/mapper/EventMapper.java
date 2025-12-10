package com.example.events.infra.mapper;

import com.example.events.core.entities.Event;
import com.example.events.core.enums.EventType;
import com.example.events.infra.dtos.EventDto;

import java.time.LocalDateTime;

public class EventMapper {
    public Event toEvent(EventDto eventDTO){
        return new Event(
                eventDTO.sponsorId(),
                eventDTO.identifier(),
                eventDTO.type(),
                eventDTO.name(),
                eventDTO.description(),
                eventDTO.startTime(),
                eventDTO.endTime(),
                eventDTO.location(),
                eventDTO.capacity()
            );
    }

    public EventDto toEvent(Event event){
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
            .build();
    }
}
