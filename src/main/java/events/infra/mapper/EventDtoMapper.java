package events.infra.mapper;

import events.core.entities.Event;
import events.infra.dto.CreateEventRequestDto;
import events.infra.dto.EventResponseDto;

import java.util.Optional;
import java.util.UUID;

public class EventDtoMapper {
    public static Event toDomain(CreateEventRequestDto requestDto){
        return new Event(
                null,
                requestDto.sponsorId(),
                null,
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
                .id(event.getId())
                .identifier(event.getIdentifier())
                .sponsorId(event.getSponsorId())
                .identifier(event.getIdentifier())
                .type(event.getType())
                .name(event.getName())
                .description(event.getDescription())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .location(event.getLocation())
                .capacity(event.getCapacity())
                .createdAt(event.getCreatedAt())
                .updatedAt(event.getUpdatedAt())
                .build();
    }
}
