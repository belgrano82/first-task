package org.aqa;

import org.aqa.exceptions.OutOfBoundsNumberException;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void playGame() {

        Random random = new Random();
        int guessedNumber = random.nextInt(1, 101);

        System.out.println("Welcome to the game \"Guess number\"!.\nYou should guess the number from 1 to 100.");

        int userNumber;
        boolean isNumberGuessed = false;

        while (!isNumberGuessed) {
            System.out.print("Enter your number: ");
            userNumber = getUserNumber();
            if (userNumber != 0) {
                isNumberGuessed = successGuess(userNumber, guessedNumber);
            }
        }

        System.out.println("Wow! You have guessed the number: " + guessedNumber + " ! My congratulations!");
        FinishProgram.exitSuccess();
    }

    private static int getUserNumber() {

        int userNumber = 0;

        Scanner scanner = new Scanner(System.in);

        try {
            userNumber = scanner.nextInt();
            if (userNumber < 1 || userNumber > 100) {
                throw new OutOfBoundsNumberException("Your number should be from 1 to 100.");
            } else return userNumber;
        } catch (InputMismatchException e) {
            System.out.println("You entered not a number. Try again.");
        } catch (OutOfBoundsNumberException e) {
            System.out.println(e.getMessage() + "Try again.");
        }
        return userNumber;
    }

    private static Boolean successGuess(int userNumber, int randomNumber) {

        boolean result = false;

        if (userNumber == randomNumber) {
            result = true;
        } else if (userNumber < randomNumber) {
            System.out.println("Your number is less than guessed number.");
        } else if (userNumber > randomNumber) {
            System.out.println("Your number is greater than guessed number.");
        }
        return result;
    }
}
