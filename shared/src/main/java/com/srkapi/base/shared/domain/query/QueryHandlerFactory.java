package com.srkapi.base.shared.domain.query;

public interface QueryHandlerFactory {
  <R> QueryHandler<Query<R>, R> createQueryHandler(String queryName);
}
