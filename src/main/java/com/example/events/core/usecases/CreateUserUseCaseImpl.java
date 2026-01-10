package com.example.events.core.usecases;

import com.example.events.core.entities.User;
import com.example.events.core.gateway.UserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        return this.userGateway.create(user);
    }
}
