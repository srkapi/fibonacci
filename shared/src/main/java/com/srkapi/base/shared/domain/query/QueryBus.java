package com.srkapi.base.shared.domain.query;

public interface QueryBus {
    <R> R ask(Query<R> query) throws Exception;
}
