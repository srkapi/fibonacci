package com.srkapi.base.shared.domain.command.middleware;


import com.srkapi.base.shared.domain.message.Message;

public interface NextMiddlewareFunction<T extends Message<R>, R> {
  R call(T message) throws Exception;
}
