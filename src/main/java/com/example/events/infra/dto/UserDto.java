package com.example.events.infra.dto;

import com.example.events.core.entities.Event;
import lombok.Builder;

@Builder
public record UserDto(
        String name,
        String email
) {
}
