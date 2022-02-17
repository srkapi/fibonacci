package com.srkapi.base.application.user.create.command;

import com.srkapi.base.shared.domain.command.Command;
import lombok.Getter;

@Getter
public class CreateUserCommand implements Command<CreateUserCommandResult> {
  private final String user;
  private final String password;
  private final String email;

  public CreateUserCommand(String user, String password, String email) {
    this.user = user;
    this.password = password;
    this.email = email;
  }
}
