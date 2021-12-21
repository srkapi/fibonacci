package com.srkapi.api.application.usecase;

import com.srkapi.api.application.port.in.model.FibonacciRequestCommand;
import com.srkapi.api.application.port.in.model.FibonacciResponse;
import com.srkapi.api.shared.UseCases;

public interface CalculateFibonacciUseCases extends UseCases<FibonacciResponse,FibonacciRequestCommand> {
}
