package com.srkapi.base.configuration;

import com.srkapi.base.application.fibonacci.FibonacciCalculator;
import com.srkapi.base.application.fibonacci.usecase.CalculateFibonacciUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public CalculateFibonacciUseCases exposeFibonacciExecutor() {
        return new FibonacciCalculator();
    }
}
