package com.example.events.core.usecases;

import com.example.events.core.entities.Event;

public interface CreateEventUseCase {
    public Event execute(Event event);
}
