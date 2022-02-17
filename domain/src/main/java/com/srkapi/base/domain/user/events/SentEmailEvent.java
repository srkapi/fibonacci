package com.srkapi.base.domain.user.events;

import com.srkapi.base.shared.domain.event.DomainEvent;
import java.io.Serializable;
import java.util.HashMap;

public class SentEmailEvent extends DomainEvent {
  @Override
  public String eventName() {
    return "SentEmailEvent";
  }

  @Override
  public HashMap<String, Serializable> toPrimitives() {
    return new HashMap<>();
  }

  @Override
  public DomainEvent fromPrimitives(
      String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
    return new SentEmailEvent();
  }
}
