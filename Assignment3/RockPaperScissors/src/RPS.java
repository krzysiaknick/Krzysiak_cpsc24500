import java.util.Random;
import java.util.Scanner;

public class RPS {

    public static void main(String[] args) {
        Boolean game = true;
        Scanner scan = new Scanner(System.in); // Moved scanner outside the loop to prevent resource leaks

        while (game) {
            Random random = new Random();
            // Displays instructions
            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.println("Instructions:");
            System.out.println("Enter a number 1-3");
            System.out.println("1 = Rock");
            System.out.println("2 = Paper");
            System.out.println("3 = Scissors");
            System.out.println();

            // Generates Computer's choice
            int computerNum = random.nextInt(3) + 1;

            int userSelection = 0;
            boolean validInput = false;

            // confirms the user imput is 1-3
            while (!validInput) {
                System.out.print("Enter your choice here (1-3): ");
                if (scan.hasNextInt()) {
                    userSelection = scan.nextInt();
                    if (userSelection >= 1 && userSelection <= 3) {
                        validInput = true; // Ends loop if input is valid
                    } else {
                        System.out.println("Invalid input. Please enter a number 1-3.");

                    }
                } else {
                    System.out.println("Invalid input. Please enter a number 1-3.");
                    scan.next(); // prevents infinite loop if a non int is entered
                }
            }


            // Prints Player and computer choices
            String playerChoice = convertNum(userSelection);
            System.out.println("You chose: " + playerChoice);

            String computerChoice = convertNum(computerNum);
            System.out.println("The Computer chose: " + computerChoice);

            // Determines a winner
            String result = determineWinner(computerNum, userSelection);
            System.out.println(result);

            // Asks player if they want to play again
            boolean playAgain = true;
            while (playAgain) {
                System.out.print("Would you like to play again? Enter Y/N: ");
                String userResponse = scan.next();

                if (userResponse.equalsIgnoreCase("Y")) {
                    game = true;
                    playAgain = false;
                } else if (userResponse.equalsIgnoreCase("N")) {
                    game = false;
                    playAgain = false;
                } else {
                    System.out.println("Invalid Input, Enter Y or N");
                }
            }
        }
    }

    // This Method converts player input from int to str
    public static String convertNum(int user) {
        switch (user) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "";
        }
    }

    // This method determines the winner
    public static String determineWinner(int computerNum, int userSelection) {
        if (computerNum == userSelection) {
            return "Tie";
        } else if ((computerNum == 1 && userSelection == 3) ||
                (computerNum == 2 && userSelection == 1) ||
                (computerNum == 3 && userSelection == 2)) {
            return "Computer Wins";
        } else {
            return "You Win!!!";
        }
    }
}
