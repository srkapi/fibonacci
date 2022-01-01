package com.srkapi.base.shared.spring;


import com.srkapi.base.shared.command.CommandHandlerFactory;
import com.srkapi.base.shared.query.QueryHandlerFactory;

public interface HandlerFactoryConfig {
  CommandHandlerFactory getCommandHandlerFactory();
  QueryHandlerFactory getQueryhandlerFactory();
}
