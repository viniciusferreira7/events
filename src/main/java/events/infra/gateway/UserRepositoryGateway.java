package events.infra.gateway;

import events.core.entities.User;
import events.core.exceptions.UserAlreadyExistsException;
import events.core.gateway.UserGateway;
import events.infra.mapper.UserEntityMapper;
import events.infra.persistence.UserEntity;
import events.infra.persistence.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;

    public UserRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        UserEntity entity = UserEntityMapper.toEntity(user);

        UserEntity userEntity = this.userRepository.findByEmail(entity.getEmail());

        if(userEntity != null){
            throw new UserAlreadyExistsException("Email already exists");
        }

        UserEntity userEntityCreated = this.userRepository.save(entity);

        return UserEntityMapper.toDomain(userEntityCreated);

    }
}
