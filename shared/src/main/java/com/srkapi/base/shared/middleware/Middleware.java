package com.srkapi.base.shared.middleware;


import com.srkapi.base.shared.DomainException;
import com.srkapi.base.shared.message.Message;

public interface Middleware {
  <R> R handle(Message<R> message, NextMiddlewareFunction<Message<R>, R> next) throws Exception, DomainException;
}
