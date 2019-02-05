package com.srdjancosic.commands;

public class HelpCommand implements Command {
    @Override
    public void call() {
        System.out.println("" +
            "quit: Quit the program"
        );
    }
}
