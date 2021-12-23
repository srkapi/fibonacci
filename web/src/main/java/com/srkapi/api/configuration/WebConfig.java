package com.srkapi.api.configuration;

import com.srkapi.api.application.fibonacci.FibonacciCalculator;
import com.srkapi.api.application.fibonacci.usecase.CalculateFibonacciUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public CalculateFibonacciUseCases exposeFibonacciExecutor() {
        return new FibonacciCalculator();
    }
}
