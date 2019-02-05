package com.srdjancosic.commands;

public class QuitCommand implements Command {
    @Override
    public void call() {
        System.exit(0);
    }
}
