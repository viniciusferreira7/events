package events.core.usecases;

import events.core.entities.Event;
import events.core.gateway.EventGateway;

public class CreateEventUseCaseImpl implements CreateEventUseCase {
    private final EventGateway eventGateway;

    public CreateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event eventData) {
       return this.eventGateway.createEvent(eventData);
    }
}
