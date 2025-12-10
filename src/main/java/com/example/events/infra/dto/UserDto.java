package com.example.events.infra.dto;

import lombok.Builder;

@Builder
public record UserDto(
        String name,
        String email
) {
}
