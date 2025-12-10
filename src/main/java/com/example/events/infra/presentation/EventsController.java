package com.example.events.infra.presentation;

import com.example.events.infra.dto.EventDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/events")
public class EventsController {

    @PostMapping
    public ResponseEntity<Void> createEvent(@RequestBody EventDto eventBody){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
