package com.srkapi.base.shared.domain.message;

public interface MessageBus {
  <R> R dispatch(Message<R> message) throws Exception;
}
