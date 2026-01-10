package com.example.events.core.usecases;

import com.example.events.core.entities.User;

public interface CreateUserUseCase {
    public User execute(User user);
}
