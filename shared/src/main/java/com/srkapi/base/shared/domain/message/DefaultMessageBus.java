package com.srkapi.base.shared.domain.message;


import com.srkapi.base.shared.domain.exceptions.NoHandlerFoundException;
import com.srkapi.base.shared.domain.command.middleware.Middleware;
import com.srkapi.base.shared.domain.command.middleware.NextMiddlewareFunction;

import java.util.ArrayList;
import java.util.List;

public final class DefaultMessageBus implements MessageBus {
    private static final int FIRST_MIDDLEWARE_INDEX = 0;

    private MessageHandlerFactory messageHandlerFactory;
    private final List<Middleware> middlewarePipeline;

    public DefaultMessageBus(MessageHandlerFactory handlerFactory, List<Middleware> middlewareList) {
        messageHandlerFactory = handlerFactory;
        middlewarePipeline = new ArrayList<>(middlewareList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> R dispatch(Message<R> message) throws Exception {
        return (R) getNext(FIRST_MIDDLEWARE_INDEX).call((Message<Object>) message);
    }

    private <R> NextMiddlewareFunction<Message<R>, R> getNext(int nextMiddlewareIndex) {
        if (nextMiddlewareIndex < middlewarePipeline.size()) {
            // Handle using next middleware
            return (message) -> {
                Middleware nextMiddleware = middlewarePipeline.get(nextMiddlewareIndex);
                return nextMiddleware.handle(message, getNext(nextMiddlewareIndex + 1));
            };
        } else {
            // Handle using message handler
            return (message) -> {
                MessageHandler<Message<R>, R> handler = messageHandlerFactory.createHandler(message.getClass().getName());
                if (handler == null) {
                    throw new NoHandlerFoundException(message.getClass());
                }
                return handler.handle(message);
            };
        }
    }
}
