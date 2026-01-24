package events.infra.mapper;

import events.core.entities.Event;
import events.infra.persistence.EventEntity;

import java.util.Optional;

public class EventEntityMapper {
    public static EventEntity toEntity(Event event){
        EventEntity entity = new EventEntity(
                event.getSponsorId(),
                event.getIdentifier(),
                event.getType(),
                event.getName(),
                event.getDescription(),
                event.getLocation(),
                event.getCapacity(),
                event.getStartTime(),
                event.getEndTime()
        );
        if (event.getId() != null) {
            entity.setId(event.getId());
        }
        return entity;
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
