package events.infra.gateway;

import events.core.entities.Event;
import events.core.gateway.EventGateway;
import events.infra.mapper.EventEntityMapper;
import events.infra.persistence.EventEntity;
import events.infra.persistence.EventEntitySpecification;
import events.infra.persistence.EventsRepository;
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
