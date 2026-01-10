package com.example.events.infra.mapper;

import com.example.events.core.entities.User;
import com.example.events.infra.persistence.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public class UserEntityMapper {
    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        if (user.id() != null) {
            entity.setId(user.id());
        }
        entity.setName(user.name());
        entity.setEmail(user.email());
        entity.setCreatedAt(user.created_at() != null ? user.created_at() : LocalDateTime.now());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getCreatedAt(),
                List.of()
        );
    }
}
