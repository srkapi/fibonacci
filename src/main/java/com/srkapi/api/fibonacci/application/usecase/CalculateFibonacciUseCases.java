package com.srkapi.api.fibonacci.application.usecase;

import com.srkapi.api.fibonacci.application.command.FibonacciCommand;
import com.srkapi.api.fibonacci.application.command.FibonacciCommandResult;
import com.srkapi.api.shared.UseCases;

public interface CalculateFibonacciUseCases extends UseCases<FibonacciCommandResult, FibonacciCommand> {
}
