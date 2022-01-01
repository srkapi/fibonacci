package com.srkapi.base.shared.command;

public interface CommandBus {
  <R> R dispatch(Command<R> command) throws Exception;
}
