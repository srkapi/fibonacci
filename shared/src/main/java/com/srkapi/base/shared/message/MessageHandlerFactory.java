package com.srkapi.base.shared.message;

public interface MessageHandlerFactory {
  <R> MessageHandler<Message<R>, R> createHandler(String messageName);
}
