package com.srkapi.base.application.fibonacci;


import com.srkapi.base.application.fibonacci.command.FibonacciCommand;
import com.srkapi.base.application.fibonacci.command.FibonacciCommandResult;
import com.srkapi.base.shared.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FibonacciCalculatorTest {
    private FibonacciCalculator fibonacciCalculator;

    @BeforeEach
    void setUp() {
        fibonacciCalculator = new FibonacciCalculator();
    }

    @Test
    public void shouldReturnExceptionWhenValueIsNegative() {
        Assertions.assertThrows(DomainException.class, () -> fibonacciCalculator.execute(new FibonacciCommand(-8)));
    }

    @Test
    public void shouldReturnResultWhenCommandIsCorrect() throws DomainException {
        FibonacciCommandResult response = fibonacciCalculator.execute(new FibonacciCommand(4));
        Assertions.assertTrue(response.getResult() >= 0);
    }

}
