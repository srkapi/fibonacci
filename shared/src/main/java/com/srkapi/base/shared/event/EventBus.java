package com.srkapi.base.shared.event;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);
}
