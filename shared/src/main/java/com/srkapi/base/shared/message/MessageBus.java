package com.srkapi.base.shared.message;

public interface MessageBus {
  <R> R dispatch(Message<R> message) throws Exception;
}
