package com.srkapi.base.shared.domain.autoscan;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface QueryMappings {
  QueryMapping[] value();
}
