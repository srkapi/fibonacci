package com.srkapi.base.shared.domain.query;


import com.srkapi.base.shared.domain.command.middleware.Middleware;
import com.srkapi.base.shared.domain.exceptions.NoHandlerFoundException;
import com.srkapi.base.shared.domain.message.*;

import java.util.List;

public final class DefaultQueryBus implements QueryBus {

    private final MessageBus defaultMessageBus;

    public DefaultQueryBus(QueryHandlerFactory queryHandlerFactory, List<Middleware> middlewareList) {
        defaultMessageBus = new DefaultMessageBus(
                new QueryHandlerFactoryToMessageHandlerFactoryAdapter(queryHandlerFactory),
                middlewareList
        );
    }

    @Override
    public <R> R ask(Query<R> query) throws Exception {
        return defaultMessageBus.dispatch(query);
    }

    // region adapter classes
    static class QueryHandlerFactoryToMessageHandlerFactoryAdapter implements MessageHandlerFactory {

        private final QueryHandlerFactory queryHandlerFactory;

        public QueryHandlerFactoryToMessageHandlerFactoryAdapter(
                QueryHandlerFactory queryHandlerFactory) {
            this.queryHandlerFactory = queryHandlerFactory;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <R> MessageHandler<Message<R>, R> createHandler(String messageName) {
            QueryHandler queryHandler = queryHandlerFactory.createQueryHandler(messageName);
            if (queryHandler == null) {
                throw new NoHandlerFoundException(messageName);
            }

            return new QueryHandlerToMessageHandlerAdapter<>(queryHandler);
        }
    }

    static class QueryHandlerToMessageHandlerAdapter<M extends Message<R>, R>
            implements MessageHandler<M, R> {

        private final QueryHandler<Query<R>, R> queryHandler;

        QueryHandlerToMessageHandlerAdapter(QueryHandler<Query<R>, R> queryHandler) {
            this.queryHandler = queryHandler;
        }

        @Override
        public R handle(M message) throws Exception {
            return queryHandler.handle(castToQuery(message));
        }

        @SuppressWarnings("unchecked")
        private Query<R> castToQuery(Message<R> message) {
            return (Query<R>) message;
        }
    }
    // endregion
}
