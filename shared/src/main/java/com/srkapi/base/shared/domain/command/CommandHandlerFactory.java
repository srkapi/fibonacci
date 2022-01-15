package com.srkapi.base.shared.domain.command;

public interface CommandHandlerFactory {
  <R> CommandHandler<Command<R>, R> createCommandHandler(String commandName);
}
