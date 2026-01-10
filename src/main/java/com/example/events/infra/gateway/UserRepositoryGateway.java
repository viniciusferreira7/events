package com.example.events.infra.gateway;

import com.example.events.core.entities.User;
import com.example.events.core.gateway.UserGateway;
import com.example.events.infra.mapper.UserEntityMapper;
import com.example.events.infra.persistence.UserEntity;
import com.example.events.infra.persistence.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;

    public UserRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        UserEntity entity = UserEntityMapper.toEntity(user);

        UserEntity userEntityCreated = this.userRepository.save(entity);

        return UserEntityMapper.toDomain(userEntityCreated);
    }
}
