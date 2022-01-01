package com.srkapi.base.shared.spring;



import com.srkapi.base.shared.middleware.Middleware;

import java.util.List;

public interface MiddlewareConfig {
    List<Middleware> getCommandMiddlewarePipeline();

    List<Middleware> getQueryMiddlewarePipeline();
}
