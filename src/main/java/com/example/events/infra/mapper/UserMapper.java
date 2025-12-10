package com.example.events.infra.mapper;


import com.example.events.core.entities.User;
import com.example.events.infra.dto.UserDto;

public class UserMapper {
    public User toUser(UserDto userDTO){
        return new User(
                userDTO.name(),
                userDTO.email()
        );
    }

    public UserDto toUserDto(User user){
        return UserDto.builder()
                .name(user.name())
                .email(user.email())
                .build();
    }
}
