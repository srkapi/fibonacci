package com.srkapi.base.shared.domain.command.middleware;


import com.srkapi.base.shared.domain.DomainException;
import com.srkapi.base.shared.domain.message.Message;

public interface Middleware {
  <R> R handle(Message<R> message, NextMiddlewareFunction<Message<R>, R> next) throws Exception, DomainException;
}
