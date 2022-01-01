package com.srkapi.base.shared.command;

public interface CommandHandlerFactory {
  <R> CommandHandler<Command<R>, R> createCommandHandler(String commandName);
}
