package com.srkapi.base.shared.command;

import com.srkapi.base.shared.DomainException;

public interface CommandBus {
    <R> R dispatch(Command<R> command) throws DomainException, Exception;
}
