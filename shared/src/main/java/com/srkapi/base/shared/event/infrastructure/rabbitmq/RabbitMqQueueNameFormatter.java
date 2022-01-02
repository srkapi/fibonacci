package com.srkapi.base.shared.event.infrastructure.rabbitmq;


import com.srkapi.base.shared.event.infrastructure.DomainEventSubscriberInformation;

public final class RabbitMqQueueNameFormatter {
    public static String format(DomainEventSubscriberInformation information) {
        return information.formatRabbitMqQueueName();
    }

    public static String formatRetry(DomainEventSubscriberInformation information) {
        return String.format("retry.%s", format(information));
    }

    public static String formatDeadLetter(DomainEventSubscriberInformation information) {
        return String.format("dead_letter.%s", format(information));
    }
}
