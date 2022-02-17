package com.srkapi.base.shared.domain.query;

import com.srkapi.base.shared.domain.message.MessageHandler;

public interface QueryHandler<Q extends Query<R>, R> extends MessageHandler<Q, R> {
  R handle(Q query) throws Exception;
}
