package com.srdjancosic.commands;

import com.srdjancosic.SudokuGenerator;

public class HelpCommand implements Command {
    @Override
    public void call(SudokuGenerator sudokuGenerator) {
        System.out.println("" +
            "quit: Quit the program" + System.lineSeparator() +
            "randomize: Randomize a new Sudoku board"
        );
    }
}
