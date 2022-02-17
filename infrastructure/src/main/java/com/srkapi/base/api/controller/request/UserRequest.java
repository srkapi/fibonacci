package com.srkapi.base.api.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {
  @Schema(required = true)
  private String name;

  @Schema(required = true)
  private String password;

  @Schema(required = true)
  private String email;
}
