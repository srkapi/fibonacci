package com.srkapi.base.configuration;

import com.srkapi.base.application.fibonacci.FibonacciCalculator;
import com.srkapi.base.application.fibonacci.usecase.CalculateFibonacciUseCases;
import com.srkapi.base.application.user.create.CreateUserCommandHandler;
import com.srkapi.base.shared.domain.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfig {


    @Bean
    public CreateUserCommandHandler exposeCreateUserCommand(@Autowired EventBus eventBus){
        return new CreateUserCommandHandler(eventBus);
    }

    @Bean
    public CalculateFibonacciUseCases exposeFibonacciExecutor() {
        return new FibonacciCalculator();
    }
}
