package events.core.usecases;

import events.core.entities.User;

public interface CreateUserUseCase {
    public User execute(User user);
}
