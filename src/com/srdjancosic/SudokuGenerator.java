package com.srdjancosic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SudokuGenerator {
    private int[][] slots;

    public SudokuGenerator() {
        this.randomizeSlots();
    }

    private void randomizeSlots() {
        this.slots = new int[4][4];
        for (int row = 0; row < 4; row++) {
            ArrayList<Integer> insertedValues = new ArrayList<>();
            for (int column = 0; column < 4; column++) {
                boolean valid = false;
                int numberOfTries = 0;
                while (!valid) {
                    if (numberOfTries >= 4 && insertedValues.size() == 3) {
                        this.makeColumnValid(row, column, insertedValues);
                        valid = true;
                        continue;
                    }

                    int value = this.getRandomNumber(insertedValues);
                    this.slots[row][column] = value;
                    valid = this.isSlotValid(row, column);

                    if (valid){
                        insertedValues.add(value);
                    }
                    numberOfTries++;
                }
            }
        }
        this.hideRandomSlots(8);
    }

    private void hideRandomSlots(int maxHiddenSlots) {
        int numberOfHiddenSlots = 0;
        Random randomizer = new Random();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (randomizer.nextInt(2) == 1){
                    this.slots[row][column] = 0;
                    numberOfHiddenSlots++;
                    if (numberOfHiddenSlots == maxHiddenSlots) {
                        return;
                    }
                }
            }
        }
    }

    private void makeColumnValid(int row, int columnIndex, ArrayList insertedValues) {
        int value = this.getRandomNumber(insertedValues);
        this.slots[row][columnIndex] = 0;
        for (int column = 0; column < 4; column++) {
            int oldValue = this.slots[row][column];
            this.slots[row][column] = value;
            this.slots[row][columnIndex] = oldValue;
            if (this.isSlotValid(row, column) && this.isSlotValid(row, columnIndex)) {
                return;
            }
            this.slots[row][column] = oldValue;
            this.slots[row][columnIndex] = 0;
        }
    }

    private boolean isSlotValid(int rowIndex, int columnIndex) {
        int value = this.slots[rowIndex][columnIndex];
        for (int row = 0; row < rowIndex; row++) {
            if (this.slots[row][columnIndex] == value) {
                return false;
            }
        }
        for (int column = 0; column < columnIndex; column++) {
            if (this.slots[rowIndex][column] == value) {
                return false;
            }
        }
        return true;
    }

    private int getRandomNumber(ArrayList insertedValues) {
        if (insertedValues.size() == 3) {
            for (int i = 1; i < 5; i++) {
                if (!insertedValues.contains(i)) {
                    return i;
                }
            }
        }
        return new Random().nextInt(4) + 1;
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
