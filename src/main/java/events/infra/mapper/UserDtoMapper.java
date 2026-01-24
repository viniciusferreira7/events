package events.infra.mapper;


import events.core.entities.User;
import events.infra.dto.CreateUserRequestDto;
import events.infra.dto.UserResponseDto;

import java.util.List;
import java.util.UUID;

public class UserDtoMapper {
    public static User toDomain(CreateUserRequestDto requestDto){
        return new User(
                null,
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
