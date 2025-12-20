package com.example.events.infra.mapper;

import com.example.events.core.entities.Event;
import com.example.events.infra.dto.CreateEventRequestDto;
import com.example.events.infra.dto.EventResponseDto;

import java.util.Optional;
import java.util.UUID;

public class EventDtoMapper {
    public static Event toDomain(CreateEventRequestDto requestDto){
        return new Event(
                UUID.randomUUID(),
                requestDto.sponsorId(),
                requestDto.identifier(),
                requestDto.type(),
                requestDto.name(),
                requestDto.description(),
                requestDto.startTime(),
                requestDto.endTime(),
                requestDto.location(),
                requestDto.capacity(),
                null,
                Optional.empty()
        );
    }

    public static EventResponseDto toResponseDto(Event event){
        return EventResponseDto.builder()
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
