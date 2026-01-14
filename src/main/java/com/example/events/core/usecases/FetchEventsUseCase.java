package com.example.events.core.usecases;

import com.example.events.core.entities.Event;

import java.util.List;

public interface FetchEventsUseCase {
    public List<Event> execute(String search);
}
