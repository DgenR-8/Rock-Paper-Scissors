/*
 * 
 * 
 */
import java.util.Scanner;
import java.util.Random;

public class ReRockPaperScissors {
    // fixed final type, unchangeable variables
    final static String[] CHOICE = {"rock", "paper", "scissors"}; // String array for rock, paper, scissors choices
    final static Random RANDOM = new Random(); // for randomization of any objects
    final static Scanner SCANNER = new Scanner(System.in); // Re-usable scanner for any user input
    
    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        runGame();
    }

    static void runGame() {
        while(true) {
            playGame();

            if (!askToContinue()) {
                System.out.println("Thanks for playing! Goodbye.\n");
                break;
            }
        }
    }

    static void playGame() {
        String computerChoice = getComputerChoice();
        String userChoice = getUserChoice();
        
        if (userChoice == null) {
            System.out.println("Invalid value! Please try again\n");
            return;
        }

        // displays user & computer choice
        System.out.println("You chose " + userChoice);
        System.out.println("Computer chose " + computerChoice);
        
        String result = determineWinner(userChoice, computerChoice);
        System.out.print(result + "\n");
    }

    static String getComputerChoice() {
        return CHOICE[RANDOM.nextInt(CHOICE.length)];
    }

    static String getUserChoice() {
        // user input & scanner - user choice 
        System.out.print("Enter choice (rock/paper/scissors): ");
        String input = SCANNER.nextLine().toLowerCase().trim();

        // Input validation
        for (String choice : CHOICE) {
            if (choice.equals(input))
            return input;
        }
        return null; // Invalid input
    }

    static String determineWinner(String user, String computer) {
        // Logic flow: choosing rock, paper or scissors & outcome
        if (user.equals(computer)) {
            return "It's a tie!";
        }
    
        boolean userWins = (user.equals("rock") && computer.equals("scissors")) ||
                            (user.equals("paper") && computer.equals("rock")) || 
                            (user.equals("scissors") && computer.equals("paper"));
        return userWins ? "You win!" : "You lose!";

    }

    static boolean askToContinue() {
        // Yes or no input - y/n choice
        while (true) { 
            System.out.print("Continue? (y/n): ");
            String response = SCANNER.nextLine().toLowerCase().trim();

            switch (response) {
                case "y", "yes" -> {
                    System.out.println("Continuing game");
                    return true;
                }
                case "n", "no" -> {
                    System.out.println("Ending Rock, Paper, Scissors\n");
                    return false;
                }
                default -> 
                    System.out.println("Invalid choice! \nEnter 'y' or 'n' again.\n");
            }
        }
    }
}


