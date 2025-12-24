package org.aqa;

import org.aqa.exceptions.OverloadLongNumberException;
import org.aqa.exceptions.ZeroAndNegativeNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.aqa.Utils.printAttempts;

public class Factorial {

    public static void executeFactorial() {

        System.out.println("Welcome to Factorial!\nEnter the number between 1 and 20:");

        int number = enterNumber();

        if (number == 0) {
            FinishProgram.exitError();
        } else {
            System.out.println("My congratulations!\nThe factorial of " + number + " is " + getFactorial(number));
            FinishProgram.exitSuccess();
        }
    }

    private static int getFactorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }

    private static int enterNumber() {
        int attempts = 0;
        int number = 0;

        while (attempts < Constants.MAX_ATTEMPTS) {

            attempts++;
            int attemptsLeft = Constants.MAX_ATTEMPTS - attempts;

            Scanner scanner = new Scanner(System.in);

            try {
                number = scanner.nextInt();
                if (number < 1) {
                    throw new ZeroAndNegativeNumberException("We can't get factorial from 0 or negative number.");
                } else if (number > 20) {
                    throw new OverloadLongNumberException("We can't put the factorial of " + number + " into Long value.");
                } else {
                    return number;
                }
            } catch (ZeroAndNegativeNumberException | OverloadLongNumberException e) {
                System.out.println(e.getMessage() + printAttempts(attemptsLeft));
            } catch (InputMismatchException e) {
                System.out.println("You entered not a number. " + printAttempts(attemptsLeft));
            }
        }
        return number;
    }
}
