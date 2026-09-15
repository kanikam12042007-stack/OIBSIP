import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("================================");

        do {

            // Generate a random number between 1 and 100
            int number = random.nextInt(100) + 1;

            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();

                attempts++;

                if (guess == number) {

                    guessed = true;

                    System.out.println("Correct! 🎉");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    // Calculate score
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Round Score: " + score);

                    break;

                } else if (guess < number) {

                    System.out.println("Too Low! Try again.");

                } else {

                    System.out.println("Too High! Try again.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessed) {

                System.out.println("\nSorry! You used all your attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nYour Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n================================");
        System.out.println("       THANK YOU FOR PLAYING!");
        System.out.println("       Final Score: " + totalScore);
        System.out.println("================================");

        scanner.close();
    }
}