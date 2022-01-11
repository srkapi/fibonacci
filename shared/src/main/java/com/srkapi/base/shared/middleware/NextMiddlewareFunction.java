package com.srkapi.base.shared.middleware;


import com.srkapi.base.shared.DomainException;
import com.srkapi.base.shared.message.Message;

public interface NextMiddlewareFunction<T extends Message<R>, R> {
  R call(T message) throws Exception;
}
