package com.srkapi.fibonacci.test.adapter.in.web;


import com.srkapi.fibonacci.test.application.port.in.model.FibonacciRequestCommand;
import com.srkapi.fibonacci.test.application.port.in.model.FibonacciResponse;
import com.srkapi.fibonacci.test.application.usecase.CalculateFibonacciUseCases;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value = "fibonacci service")
@RequestMapping("/fibonacci")
public class FibonacciControllerRest {

    private final CalculateFibonacciUseCases fibonacciUseCases;

    @PostMapping
    @ApiOperation(value = "calculator fibonacci")
    public ResponseEntity calculateFibonacci(@RequestBody FibonacciRequestCommand fibonacciRequestCommand) {

        FibonacciResponse resultFibonacci = this.fibonacciUseCases.process(fibonacciRequestCommand);
        return new ResponseEntity(resultFibonacci, HttpStatus.OK);

    }
}
