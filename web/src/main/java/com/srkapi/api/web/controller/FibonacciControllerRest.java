package com.srkapi.api.web.controller;


import com.srkapi.api.fibonacci.application.command.FibonacciCommand;
import com.srkapi.api.fibonacci.application.command.FibonacciCommandResult;
import com.srkapi.api.fibonacci.application.usecase.CalculateFibonacciUseCases;
import com.srkapi.api.shared.ApplicationException;
import com.srkapi.api.shared.DomainException;
import com.srkapi.api.web.controller.request.CalculatorRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@Api(value = "fibonacci service")
@RequestMapping("/fibonacci")
public class FibonacciControllerRest {

    private final CalculateFibonacciUseCases fibonacciUseCases;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "calculator fibonacci")
    public ResponseEntity calculateFibonacci(@RequestBody @Valid CalculatorRequest request) throws ApplicationException {
        try {
            FibonacciCommandResult result = this.fibonacciUseCases.execute(new FibonacciCommand(request.getNumber()));
            return ResponseEntity.ok().body(result);
        } catch (DomainException e) {
            throw new ApplicationException(e.getCode(), e.getDetail());
        }
    }
}
