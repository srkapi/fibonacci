package com.srkapi.base.shared.infrastructure.spring;


import com.srkapi.base.shared.domain.command.CommandHandlerFactory;
import com.srkapi.base.shared.domain.query.QueryHandlerFactory;

public interface HandlerFactoryConfig {
  CommandHandlerFactory getCommandHandlerFactory();
  QueryHandlerFactory getQueryhandlerFactory();
}
