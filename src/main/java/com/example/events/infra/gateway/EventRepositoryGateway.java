package com.example.events.infra.gateway;

import com.example.events.core.entities.Event;
import com.example.events.core.gateway.EventGateway;
import com.example.events.infra.mapper.EventEntityMapper;
import com.example.events.infra.persistence.EventEntity;
import com.example.events.infra.persistence.EventEntitySpecification;
import com.example.events.infra.persistence.EventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventRepositoryGateway implements EventGateway {
    private final EventsRepository eventsRepository;

    public EventRepositoryGateway(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }


    @Override
    public Event createEvent(Event eventData) {
        EventEntity eventEntity = EventEntityMapper.toEntity(eventData);

        EventEntity eventEntityCreated = this.eventsRepository.save(eventEntity);

        return EventEntityMapper.toDomain(eventEntityCreated);
    }

    @Override
    public List<Event> fetchEvents(String search) {
        return this.eventsRepository.findAll(EventEntitySpecification.filter(search))
                .stream()
                .map(EventEntityMapper::toDomain)
                .toList();
    }
}
