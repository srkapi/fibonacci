package com.srkapi.base.shared.exceptions;

public class CommandBusException extends RuntimeException {

  public CommandBusException(String message) {
    super(message);
  }
}
