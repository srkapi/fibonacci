package com.srkapi.base.shared.infrastructure.rabbitmq;

import com.srkapi.base.shared.domain.event.DomainEvent;
import com.srkapi.base.shared.domain.event.EventBus;
import java.util.List;
import org.springframework.amqp.AmqpException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class RabbitMqEventBus implements EventBus {
  private final RabbitMqPublisher publisher;
  private final String exchangeName;

  public RabbitMqEventBus(RabbitMqPublisher publisher) {
    this.publisher = publisher;
    this.exchangeName = "domain_events";
  }

  @Override
  public void publish(List<DomainEvent> events) {
    events.forEach(this::publish);
  }

  private void publish(DomainEvent domainEvent) {
    try {
      this.publisher.publish(domainEvent, exchangeName);
    } catch (AmqpException error) {
      // failoverPublisher.publish(Collections.singletonList(domainEvent));
    }
  }
}
