package com.srkapi.base.shared.query;


import com.srkapi.base.shared.message.MessageHandler;

public interface QueryHandler<Q extends Query<R>, R> extends MessageHandler<Q, R> {
    R handle(Q query) throws Exception;
}
