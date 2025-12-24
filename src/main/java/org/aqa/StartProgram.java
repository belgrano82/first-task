package org.aqa;

import org.aqa.exceptions.WrongNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.aqa.Utils.printAttempts;

public class StartProgram {

    public static void selectTask() {
        System.out.println("""
                
                Choose task for reviewing
                
                Enter number:
                1 - Factorial
                2 - Game "Guess number"
                """);
        int selectedTask = getNumberOfTask();

        switch (selectedTask) {
            case 0 -> FinishProgram.exitError();
            case 1 -> Factorial.executeFactorial();
            case 2 -> GuessNumber.playGame();
        }
    }

    private static int getNumberOfTask() {

        int numberOfTask = 0;
        int attempts = 0;

        while (attempts < Constants.MAX_ATTEMPTS) {

            attempts++;
            int attemptsLeft = Constants.MAX_ATTEMPTS - attempts;

            Scanner scanner = new Scanner(System.in);

            try {
                numberOfTask = scanner.nextInt();
                if (numberOfTask < 1 || numberOfTask > 2) {
                    throw new WrongNumberException();
                }
                return numberOfTask;
            } catch (InputMismatchException exception) {
                System.out.println("You entered not a number. " + printAttempts(attemptsLeft));
            } catch (WrongNumberException exception) {
                System.out.println("You entered wrong number. " + printAttempts(attemptsLeft));
            }
        }
        return numberOfTask;
    }
}
