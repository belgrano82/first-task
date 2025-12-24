package org.aqa;

public class Utils {
    public static String printAttempts(int attemptsLeft) {
        if (attemptsLeft == 0) {
            return "Attempts left: " + attemptsLeft + ".";
        } else {
            return  "Attempts left: " + attemptsLeft + ". Try again";
        }
    }
}
