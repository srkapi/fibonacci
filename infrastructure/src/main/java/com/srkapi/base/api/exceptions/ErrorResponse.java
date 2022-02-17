package com.srkapi.base.api.exceptions;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
public class ErrorResponse {
  private String message;
  private List<String> errors;

  public ErrorResponse(String message, List<String> errors) {
    this.message = message;
    this.errors = errors;
  }
}
