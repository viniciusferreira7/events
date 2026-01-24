package events.core.usecases;

import events.core.entities.Event;

public interface CreateEventUseCase {
    public Event execute(Event event);
}
