package com.srkapi.api.fibonacci.configuration;

import com.srkapi.api.fibonacci.application.FibonacciCalculator;
import com.srkapi.api.fibonacci.application.usecase.CalculateFibonacciUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public CalculateFibonacciUseCases exposeFibonacciExecutor() {
        return new FibonacciCalculator();
    }
}
