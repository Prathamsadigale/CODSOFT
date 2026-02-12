import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRoundsWon = 0;
        boolean playAgain = true;

        System.out.println("===== Welcome to Number Guessing Game =====");

        while (playAgain) {

            int min = 1;
            int max = 100;
            int maxAttempts = 7;

            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between " + min + " and " + max);
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalRoundsWon++;
                    break;
                } 
                else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } 
                else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Remaining attempts: " + (maxAttempts - attempts));
            }

            if (guessedCorrectly) {
                System.out.println("\nYou've used all attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next();

            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n===== Game Over =====");
        System.out.println("Total Rounds Won: " + totalRoundsWon);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}
