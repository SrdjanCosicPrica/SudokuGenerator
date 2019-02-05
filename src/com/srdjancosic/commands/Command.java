package com.srdjancosic.commands;

import com.srdjancosic.SudokuGenerator;

public interface Command {
    void call(SudokuGenerator sudokuGenerator);
}
