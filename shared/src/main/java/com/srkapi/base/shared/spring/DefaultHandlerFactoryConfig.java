package com.srkapi.base.shared.spring;

import com.srkapi.base.shared.command.CommandHandlerFactory;
import com.srkapi.base.shared.query.QueryHandlerFactory;
import org.springframework.context.ApplicationContext;

public class DefaultHandlerFactoryConfig implements HandlerFactoryConfig {
  private SpringAutoScanHandlerFactory springAutoScanHandlerFactory;

  public DefaultHandlerFactoryConfig(ApplicationContext context, String basePackage) {
    this.springAutoScanHandlerFactory = new SpringAutoScanHandlerFactory(context,basePackage);
  }

  @Override
  public CommandHandlerFactory getCommandHandlerFactory() {
    return springAutoScanHandlerFactory;
  }

  @Override
  public QueryHandlerFactory getQueryhandlerFactory() {
    return springAutoScanHandlerFactory;
  }
}
