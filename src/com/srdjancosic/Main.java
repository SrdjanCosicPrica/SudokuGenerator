package com.srdjancosic;

import com.srdjancosic.commands.Command;
import com.srdjancosic.commands.HelpCommand;
import com.srdjancosic.commands.QuitCommand;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static Map<String, Command> choices = Map.of(
        "quit", new QuitCommand(),
        "help", new HelpCommand()
    );

    public static void main(String[] args) {
        SudokuGenerator sudokuGenerator = new SudokuGenerator();
        System.out.println("Welcome to Sudoku Generator");
        boolean printInfo = true;
        while (true) {
            if (printInfo) {
                System.out.println(sudokuGenerator.toString());
                System.out.println("Type \"help\" to see a list of commands");
            }
            printInfo = awaitInput();
        }
    }

    private static boolean awaitInput() {
        String choice = scanner.nextLine();
        try {
            choices.get(choice).call();
        } catch (NullPointerException ignored) {
            System.out.printf("Unrecognized command %s%n", choice);
        }
        return !choice.equals("help");
    }
}
