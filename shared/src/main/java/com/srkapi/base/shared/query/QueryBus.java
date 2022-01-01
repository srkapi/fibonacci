package com.srkapi.base.shared.query;

public interface QueryBus {
    <R> R dispatch(Query<R> query) throws Exception;
}
