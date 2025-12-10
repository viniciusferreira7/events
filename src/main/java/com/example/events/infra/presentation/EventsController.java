package com.example.events.infra.presentation;

import com.example.events.infra.dtos.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/events")
public class EventsController {

    @PostMapping
    public ResponseEntity<Void> createEvent(@RequestBody EventDto eventBody){

    }
}
