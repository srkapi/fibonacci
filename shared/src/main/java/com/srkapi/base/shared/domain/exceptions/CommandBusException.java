package com.srkapi.base.shared.domain.exceptions;

public class CommandBusException extends RuntimeException {

  public CommandBusException(String message) {
    super(message);
  }
}
