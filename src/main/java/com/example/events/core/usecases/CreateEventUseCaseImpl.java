package com.example.events.core.usecases;

import com.example.events.core.entities.Event;
import com.example.events.core.gateway.EventGateway;
import org.springframework.stereotype.Service;

@Service
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
