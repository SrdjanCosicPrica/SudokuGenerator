package com.srdjancosic.commands;

import com.srdjancosic.SudokuGenerator;

public class QuitCommand implements Command {
    @Override
    public void call(SudokuGenerator sudokuGenerator) {
        System.exit(0);
    }
}
