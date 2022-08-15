package com.srkapi.base.shared.infrastructure.rabbitmq;

import com.srkapi.base.shared.infrastructure.DomainEventSubscribersInformation;
import com.srkapi.base.shared.infrastructure.DomainEventsInformation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqEventBusConfiguration {
  private final DomainEventSubscribersInformation domainEventSubscribersInformation;
  private final DomainEventsInformation domainEventsInformation;
  private final String exchangeName;
  private final String host;
  private final Integer port;
  private final String login;
  private final String password;

  public RabbitMqEventBusConfiguration(
      DomainEventSubscribersInformation domainEventSubscribersInformation,
      DomainEventsInformation domainEventsInformation,
      @Value("${rabbitmq.exchange}") String exchange,
      @Value("${rabbitmq.host}") String host,
      @Value("${rabbitmq.port}") Integer port,
      @Value("${rabbitmq.login}") String login,
      @Value("${rabbitmq.password}") String password) {
    this.domainEventSubscribersInformation = domainEventSubscribersInformation;
    this.domainEventsInformation = domainEventsInformation;
    this.exchangeName = exchange;
    this.host = host;
    this.port = port;
    this.login = login;
    this.password = password;
  }

  @Bean
  public CachingConnectionFactory connection() {
    CachingConnectionFactory factory = new CachingConnectionFactory();
    factory.setHost(host);
    factory.setPort(port);
    factory.setUsername(login);
    factory.setPassword(password);
    return factory;
  }

  @Bean
  public Declarables declaration() {
    String retryExchangeName = RabbitMqExchangeNameFormatter.retry(exchangeName);
    String deadLetterExchangeName = RabbitMqExchangeNameFormatter.deadLetter(exchangeName);
    TopicExchange domainEventsExchange = new TopicExchange(exchangeName, true, false);
    TopicExchange retryDomainEventsExchange = new TopicExchange(retryExchangeName, true, false);
    TopicExchange deadLetterDomainEventsExchange =
        new TopicExchange(deadLetterExchangeName, true, false);
    List<Declarable> declarables = new ArrayList<>();
    declarables.add(domainEventsExchange);
    declarables.add(retryDomainEventsExchange);
    declarables.add(deadLetterDomainEventsExchange);

    Collection<Declarable> queuesAndBindings =
        declareQueuesAndBindings(
                domainEventsExchange, retryDomainEventsExchange, deadLetterDomainEventsExchange)
            .stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    declarables.addAll(queuesAndBindings);

    return new Declarables(declarables);
  }

  private Collection<Collection<Declarable>> declareQueuesAndBindings(
      TopicExchange domainEventsExchange,
      TopicExchange retryDomainEventsExchange,
      TopicExchange deadLetterDomainEventsExchange) {
    return domainEventSubscribersInformation.all().stream()
        .map(
            information -> {
              String queueName = RabbitMqQueueNameFormatter.format(information);
              String retryQueueName = RabbitMqQueueNameFormatter.formatRetry(information);
              String deadLetterQueueName = RabbitMqQueueNameFormatter.formatDeadLetter(information);

              Queue queue = QueueBuilder.durable(queueName).build();
              Queue retryQueue =
                  QueueBuilder.durable(retryQueueName)
                      .withArguments(retryQueueArguments(domainEventsExchange, queueName))
                      .build();
              Queue deadLetterQueue = QueueBuilder.durable(deadLetterQueueName).build();

              Binding fromExchangeSameQueueBinding =
                  BindingBuilder.bind(queue).to(domainEventsExchange).with(queueName);

              Binding fromRetryExchangeSameQueueBinding =
                  BindingBuilder.bind(retryQueue).to(retryDomainEventsExchange).with(queueName);

              Binding fromDeadLetterExchangeSameQueueBinding =
                  BindingBuilder.bind(deadLetterQueue)
                      .to(deadLetterDomainEventsExchange)
                      .with(queueName);

              List<Binding> fromExchangeDomainEventsBindings =
                  information.subscribedEvents().stream()
                      .map(
                          domainEventClass -> {
                            String eventName = domainEventsInformation.forClass(domainEventClass);
                            return BindingBuilder.bind(queue)
                                .to(domainEventsExchange)
                                .with(eventName);
                          })
                      .collect(Collectors.toList());

              List<Declarable> queuesAndBindings = new ArrayList<>();
              queuesAndBindings.add(queue);
              queuesAndBindings.add(fromExchangeSameQueueBinding);
              queuesAndBindings.addAll(fromExchangeDomainEventsBindings);

              queuesAndBindings.add(retryQueue);
              queuesAndBindings.add(fromRetryExchangeSameQueueBinding);

              queuesAndBindings.add(deadLetterQueue);
              queuesAndBindings.add(fromDeadLetterExchangeSameQueueBinding);

              return queuesAndBindings;
            })
        .collect(Collectors.toList());
  }

  private HashMap<String, Object> retryQueueArguments(TopicExchange exchange, String routingKey) {
    return new HashMap<String, Object>() {
      {
        put("x-dead-letter-exchange", exchange.getName());
        put("x-dead-letter-routing-key", routingKey);
        put("x-message-ttl", 1000);
      }
    };
  }
}
