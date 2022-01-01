package com.srkapi.base.shared.autoscan;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandMappings {
  CommandMapping[] value();
}
