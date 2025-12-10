package com.example.events.infra.mapper;

import com.example.events.core.entities.Event;
import com.example.events.infra.dto.EventDto;

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

    public EventDto toEventDto(Event event){
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
