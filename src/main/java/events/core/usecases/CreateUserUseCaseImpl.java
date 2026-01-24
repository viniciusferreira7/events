package events.core.usecases;

import events.core.entities.User;
import events.core.exceptions.UserAlreadyExistsException;
import events.core.gateway.UserGateway;

import java.util.Optional;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        Optional<User> userOptional = this.userGateway.findByEmail(user.email());

        if(userOptional.isPresent()){
            throw new UserAlreadyExistsException("Email already exists");
        }

        return this.userGateway.create(user);

    }
}
