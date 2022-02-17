package com.srkapi.base;

import com.srkapi.base.shared.infrastructure.rabbitmq.RabbitMqDomainEventsConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        activateConsumerOfRabbitMq(context);
    }

    private static void activateConsumerOfRabbitMq(ConfigurableApplicationContext context) {
        RabbitMqDomainEventsConsumer rabbitMqDomainEventsConsumer = (RabbitMqDomainEventsConsumer) context.getBean("rabbitMqDomainEventsConsumer");
        rabbitMqDomainEventsConsumer.start();
    }


}
