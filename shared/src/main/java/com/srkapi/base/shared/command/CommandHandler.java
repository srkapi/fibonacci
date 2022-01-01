package com.srkapi.base.shared.command;


import com.srkapi.base.shared.message.MessageHandler;

public interface CommandHandler<C extends Command<R>, R> extends MessageHandler<C, R> {
    R handle(C command) throws Exception;
}
