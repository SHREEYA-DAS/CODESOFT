// TASK 1
// NUMBER GAME

// 1. Generate a random number within a specified range, such as 1 to 100.
// 2. Prompt the user to enter their guess for the generated number.
// 3. Compare the user's guess with the generated number and provide feedback on whether the guess
// is correct, too high, or too low.
// 4. Repeat steps 2 and 3 until the user guesses the correct number.
// You can incorporate additional details as follows:
// 5. Limit the number of attempts the user has to guess the number.
// 6. Add the option for multiple rounds, allowing the user to play again.
// 7. Display the user's score, which can be based on the number of attempts taken or rounds won


import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;
        int noOfAttempts = 10; // Limit the number of attempts the user has to guess the number

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            // Generate a random integer number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1; 
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("A random number between 1 and 100 has been generated. Can you guess it correctly?");

            while (attempts < noOfAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number!");
                    hasGuessedCorrectly = true;
                    score += noOfAttempts - attempts;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attempts == 10 && !hasGuessedCorrectly) {
                    System.out.println("Your total number of attempts are over! The correct number was " + numberToGuess);
                }
            }

            System.out.println("Your current score is: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
