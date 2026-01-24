package events.core.gateway;

import events.core.entities.User;

import java.util.Optional;

public interface UserGateway {
    User create(User user);
    Optional<User> findByEmail(String email);
}
