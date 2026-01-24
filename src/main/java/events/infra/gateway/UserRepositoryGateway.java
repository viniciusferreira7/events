package events.infra.gateway;

import events.core.entities.User;
import events.core.gateway.UserGateway;
import events.infra.mapper.UserEntityMapper;
import events.infra.persistence.UserEntity;
import events.infra.persistence.UserRepository;
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
