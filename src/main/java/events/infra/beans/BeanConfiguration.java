package events.infra.beans;

import events.core.gateway.EventGateway;
import events.core.gateway.UserGateway;
import events.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway){
        return new CreateEventUseCaseImpl(eventGateway);
    }

    @Bean
    public FetchEventsUseCase fetchEventsUseCase(EventGateway eventGateway){
        return new FetchEventsUseCaseImpl(eventGateway) {
        };
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway
            userGateway){
        return new CreateUserUseCaseImpl(userGateway);
    }
}
