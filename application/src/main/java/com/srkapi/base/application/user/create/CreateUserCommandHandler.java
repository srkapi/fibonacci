package com.srkapi.base.application.user.create;

import com.srkapi.base.application.user.create.command.CreateUserCommand;
import com.srkapi.base.application.user.create.command.CreateUserCommandResult;
import com.srkapi.base.shared.autoscan.CommandMapping;
import com.srkapi.base.shared.command.CommandHandler;
import com.srkapi.base.shared.event.EventBus;

@CommandMapping(value = CreateUserCommand.class)
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, CreateUserCommandResult> {

    private final EventBus eventBus;

    public CreateUserCommandHandler(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public CreateUserCommandResult handle(CreateUserCommand command) throws Exception {


        return null;
    }
}
