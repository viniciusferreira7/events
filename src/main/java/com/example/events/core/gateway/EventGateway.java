package com.example.events.core.gateway;

import com.example.events.core.entities.Event;

import java.util.List;

public interface EventGateway {
    Event createEvent(Event event);
    List<Event> fetchEvents(String search);
}
