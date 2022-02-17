package com.srkapi.base.shared.infrastructure.spring;

import com.srkapi.base.shared.domain.event.DomainEvent;
import com.srkapi.base.shared.domain.event.EventBus;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;

public class SpringApplicationEventBus implements EventBus {
  private final ApplicationEventPublisher publisher;

  public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  @Override
  public void publish(final List<DomainEvent> events) {
    events.forEach(this::publish);
  }

  private void publish(final DomainEvent event) {
    this.publisher.publishEvent(event);
  }
}
