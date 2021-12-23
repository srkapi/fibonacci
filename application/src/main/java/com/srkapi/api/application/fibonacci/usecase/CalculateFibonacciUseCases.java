package com.srkapi.api.application.fibonacci.usecase;

import com.srkapi.api.application.fibonacci.command.FibonacciCommand;
import com.srkapi.api.application.fibonacci.command.FibonacciCommandResult;
import com.srkapi.api.shared.UseCases;

public interface CalculateFibonacciUseCases extends UseCases<FibonacciCommandResult, FibonacciCommand> {
}
