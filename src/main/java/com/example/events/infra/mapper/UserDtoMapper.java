package com.example.events.infra.mapper;


import com.example.events.core.entities.User;
import com.example.events.infra.dto.CreateUserRequestDto;
import com.example.events.infra.dto.UserResponseDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserMapper {
    public static User toDomain(CreateUserRequestDto requestDto){
        return new User(
                UUID.randomUUID(),
                requestDto.name(),
                requestDto.email(),
                null,
                List.of()
        );
    }

    public static UserResponseDto toResponseDto(User user){
        return UserResponseDto.builder()
                .id(user.id())
                .name(user.name())
                .email(user.email())
                .createdAt(user.created_at())
                .events(user.events())
                .build();
    }
}
