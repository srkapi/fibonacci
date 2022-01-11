package com.srkapi.base.application.user.create;

import com.srkapi.base.application.user.create.command.CreateUserCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateUserCommandHandlerTest {

    @InjectMocks
    private CreateUserCommandHandler commandHandler;

    @Test
    public void shouldSaveUserWhenEmailDoesntExits() throws Exception {
        commandHandler.handle(new CreateUserCommand("albert", "Password0.", "kapi@email.com"));
    }

}
