package com.example.events.core.usecases;

import com.example.events.core.entities.Event;

import java.time.LocalDateTime;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    @Override
    public Event execute(Event event) {
        return new Event(
                event.id(),
                event.organizerId(),
                event.identifier(),
                event.type(),
                event.name(),
                event.description(),
                event.startTime(),
                event.endTime(),
                event.local(),
                event.capacity(),
                LocalDateTime.now(),
                null
        );
    }
}
