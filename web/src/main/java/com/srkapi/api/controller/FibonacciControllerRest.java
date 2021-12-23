package com.srkapi.api.controller;


import com.srkapi.api.application.fibonacci.command.FibonacciCommand;
import com.srkapi.api.application.fibonacci.command.FibonacciCommandResult;
import com.srkapi.api.application.fibonacci.usecase.CalculateFibonacciUseCases;
import com.srkapi.api.controller.request.CalculatorRequest;
import com.srkapi.api.shared.ApplicationException;
import com.srkapi.api.shared.DomainException;
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
@Api(value = "fibonacci rest controller")
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
