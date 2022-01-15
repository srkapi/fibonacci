package com.srkapi.base.shared.domain.command;

import com.srkapi.base.shared.domain.DomainException;

public interface CommandBus {
    <R> R dispatch(Command<R> command) throws DomainException, Exception;
}
