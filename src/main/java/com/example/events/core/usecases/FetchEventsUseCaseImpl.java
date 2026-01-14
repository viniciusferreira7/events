package com.example.events.core.usecases;

import com.example.events.core.entities.Event;
import com.example.events.core.gateway.EventGateway;

import java.util.List;

public class FetchEventsUseCaseImpl implements FetchEventsUseCase{
    private final EventGateway eventGateway;

    public FetchEventsUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute(String search) {
        return this.eventGateway.fetchEvents(search);
    }
}
