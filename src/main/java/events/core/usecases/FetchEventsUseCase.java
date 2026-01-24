package events.core.usecases;

import events.core.entities.Event;

import java.util.List;

public interface FetchEventsUseCase {
    public List<Event> execute(String search);
}
