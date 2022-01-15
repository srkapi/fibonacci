package com.srkapi.base.shared.infrastructure.spring;



import com.srkapi.base.shared.domain.command.middleware.Middleware;

import java.util.List;

public interface MiddlewareConfig {
    List<Middleware> getCommandMiddlewarePipeline();

    List<Middleware> getQueryMiddlewarePipeline();
}
