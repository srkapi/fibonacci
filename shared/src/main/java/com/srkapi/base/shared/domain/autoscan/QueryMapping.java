package com.srkapi.base.shared.domain.autoscan;



import com.srkapi.base.shared.domain.query.Query;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(QueryMappings.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryMapping {
    Class<? extends Query> value();
}
