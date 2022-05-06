package com.udemy.basic.dp.behavioral.command;

import com.udemy.basic.dp.behavioral.command.command.Command;

public class FileInvoker {
    public Command command;

    public FileInvoker(Command c) {
        command = c;
    }

    public void execute() {
        command.execute();
    }
}
