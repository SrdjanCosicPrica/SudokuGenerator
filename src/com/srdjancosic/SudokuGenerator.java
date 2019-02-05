package com.srdjancosic;

import java.util.Arrays;

public class SudokuGenerator {
    private int slots[][];

    public SudokuGenerator() {
        this.randomizeSlots();
    }

    private void randomizeSlots() {
        this.slots = new int[4][4];
    }

    @Override
    public String toString() {
        return Arrays.deepToString(
            this.slots
        ).replace("[[", ""
        ).replaceAll("[\\[\\]]", System.lineSeparator()
        ).replace("]]", ""
        ).replace(",", ""
        ).replace("0", "-");
    }
}
