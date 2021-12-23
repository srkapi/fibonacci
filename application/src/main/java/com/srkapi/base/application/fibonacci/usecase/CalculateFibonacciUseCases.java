package com.srkapi.base.application.fibonacci.usecase;

import com.srkapi.base.application.fibonacci.command.FibonacciCommand;
import com.srkapi.base.application.fibonacci.command.FibonacciCommandResult;
import com.srkapi.base.shared.UseCases;

public interface CalculateFibonacciUseCases extends UseCases<FibonacciCommandResult, FibonacciCommand> {
}
