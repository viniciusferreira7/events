package com.example.events.infra.gateway;

import com.example.events.core.entities.Event;
import com.example.events.core.gateway.EventGateway;
import com.example.events.infra.mapper.EventEntityMapper;
import com.example.events.infra.persistence.EventEntity;
import com.example.events.infra.persistence.EventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {
    private EventsRepository eventsRepository;

    @Override
    public Event createEvent(Event eventData) {
        EventEntity eventEntity = EventEntityMapper.toEntity(eventData);

        EventEntity eventEntityCreated = this.eventsRepository.save(eventEntity);

        return EventEntityMapper.toDomain(eventEntityCreated);
    }
}
