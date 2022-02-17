package com.srkapi.base.shared.infrastructure.spring;

import com.srkapi.base.shared.domain.LoggingMiddleware;
import com.srkapi.base.shared.domain.command.middleware.Middleware;
import java.util.Collections;
import java.util.List;

public class DefaultMiddlewareConfig implements MiddlewareConfig {
  @Override
  public List<Middleware> getCommandMiddlewarePipeline() {
    return Collections.singletonList(new LoggingMiddleware());
  }

  @Override
  public List<Middleware> getQueryMiddlewarePipeline() {
    return Collections.singletonList(new LoggingMiddleware());
  }
}
