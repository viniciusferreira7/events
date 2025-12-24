package com.example.events.core.gateway;

import com.example.events.core.entities.Event;

public interface EventGateway {
    Event createEvent(Event event);
}
