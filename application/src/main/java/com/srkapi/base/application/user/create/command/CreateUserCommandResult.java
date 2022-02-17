package com.srkapi.base.application.user.create.command;

import lombok.Getter;

@Getter
public class CreateUserCommandResult {
  private final String id;

  public CreateUserCommandResult(String id) {
    this.id = id;
  }
}
