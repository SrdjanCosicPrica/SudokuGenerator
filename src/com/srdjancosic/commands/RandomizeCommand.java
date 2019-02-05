package com.srdjancosic.commands;

import com.srdjancosic.SudokuGenerator;

public class RandomizeCommand implements Command {
    @Override
    public void call(SudokuGenerator sudokuGenerator) {
        sudokuGenerator.randomizeSlots();
    }
}
