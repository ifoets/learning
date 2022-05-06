package com.udemy.basic.dp.behavioral.command.command;

import com.udemy.basic.dp.behavioral.command.receiver.FileSystemReceiver;

public class WriteFileCommand implements Command {
    private final FileSystemReceiver fileSystemReceiver;

    // store previous state for undo

    public WriteFileCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        // save previous state for undo
        fileSystemReceiver.writeFile();
    }
}
