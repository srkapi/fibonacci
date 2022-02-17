package com.srkapi.base.shared.infrastructure.rabbitmq;

import com.srkapi.base.shared.domain.event.DomainEvent;
import com.srkapi.base.shared.infrastructure.DomainEventJsonSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public final class RabbitMqPublisher {
  private final RabbitTemplate rabbitTemplate;

  public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publish(DomainEvent domainEvent, String exchangeName) {
    String serializedDomainEvent = DomainEventJsonSerializer.serialize(domainEvent);

    Message message =
        new Message(
            serializedDomainEvent.getBytes(),
            MessagePropertiesBuilder.newInstance()
                .setContentEncoding("utf-8")
                .setContentType("application/json")
                .build());
    try {
      rabbitTemplate.send(exchangeName, domainEvent.eventName(), message);
    } catch (Exception e) {
      log.error("error send to queue ", e);
    }
  }

  public void publish(Message domainEvent, String exchangeName, String routingKey)
      throws AmqpException {
    rabbitTemplate.send(exchangeName, routingKey, domainEvent);
  }
}
