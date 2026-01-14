package com.example.events.infra.beans;

import com.example.events.core.gateway.EventGateway;
import com.example.events.core.gateway.UserGateway;
import com.example.events.core.usecases.*;
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
