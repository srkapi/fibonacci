package com.srkapi.base.shared.message;

import com.srkapi.base.shared.DomainException;

public interface MessageBus {
  <R> R dispatch(Message<R> message) throws Exception;
}
