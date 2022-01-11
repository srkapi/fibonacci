package com.srkapi.base.api.controller;

import com.srkapi.base.api.controller.request.UserRequest;
import com.srkapi.base.application.user.create.command.CreateUserCommand;
import com.srkapi.base.application.user.create.command.CreateUserCommandResult;
import com.srkapi.base.shared.ApplicationException;
import com.srkapi.base.shared.DomainException;
import com.srkapi.base.shared.Errors;
import com.srkapi.base.shared.command.CommandBus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "user")
@RequestMapping("/users")
public class UserControllerRest {
    private final CommandBus commandBus;


    @RequestMapping(method = RequestMethod.POST)
    @Operation(summary = "create user", description = "create user")
    public ResponseEntity createUser(@RequestBody @Valid UserRequest request) throws ApplicationException {
        try {
            CreateUserCommandResult createUserCommandResult = this.commandBus.dispatch(getCommand(request));
            return ResponseEntity.ok().body(createUserCommandResult);
        } catch (DomainException e) {
            throw new ApplicationException(e.getCode(), e.getDetail());
        } catch (Exception e) {
            throw new ApplicationException(Errors.INTERNAL_ERROR, "generic error");
        }
    }

    private CreateUserCommand getCommand(UserRequest request) {
        return new CreateUserCommand(request.getName(), request.getPassword(), request.getEmail());
    }

}
