package com.srkapi.base.shared.domain.message;

public interface MessageHandlerFactory {
  <R> MessageHandler<Message<R>, R> createHandler(String messageName);
}
