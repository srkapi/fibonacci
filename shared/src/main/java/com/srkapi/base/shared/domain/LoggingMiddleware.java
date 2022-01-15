package com.srkapi.base.shared.domain;

import com.srkapi.base.shared.domain.command.Command;
import com.srkapi.base.shared.domain.message.Message;
import com.srkapi.base.shared.domain.command.middleware.Middleware;
import com.srkapi.base.shared.domain.command.middleware.NextMiddlewareFunction;
import com.srkapi.base.shared.domain.query.Query;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingMiddleware implements Middleware {

    @Override
    public <R> R handle(Message<R> message, NextMiddlewareFunction<Message<R>, R> next) throws Exception, DomainException {
        log.info(String.format("Received %s (%s), the %s has been dispatched to %s bus",
                message.getClass().getName(), message.toString(), getMessageType(message),
                getMessageType(message)));
        try {
            R result = next.call(message);

            String serializedResult = result != null ? result.toString() : null;
            log.info(String.format("The %s %s (%s) has been handled successfully with result: %s",
                    getMessageType(message), message.getClass().getName(), message.toString(), serializedResult));

            return result;
        } catch (Exception ex) {
            log.error(String.format("Failed to handle %s (%s)", message.getClass().getName(), message.toString()), ex);
            throw ex;
        }
    }

    private String getMessageType(Message<?> message) {
        if (message instanceof Command<?>) {
            return "command";
        } else if (message instanceof Query<?>) {
            return "query";
        } else {
            return "message";
        }
    }
}
