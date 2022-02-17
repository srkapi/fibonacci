package com.srkapi.base.events;

import com.srkapi.base.domain.user.events.SentEmailEvent;
import com.srkapi.base.shared.domain.event.DomainEventSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@DomainEventSubscriber({SentEmailEvent.class})
public final class SendEmailToUser {

  @EventListener
  public void on(SentEmailEvent event) {
    log.info("event listener");
  }
}
