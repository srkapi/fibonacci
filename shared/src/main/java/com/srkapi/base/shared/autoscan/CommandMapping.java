package com.srkapi.base.shared.autoscan;



import com.srkapi.base.shared.command.Command;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(CommandMappings.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandMapping {
    Class<? extends Command> value();
}
