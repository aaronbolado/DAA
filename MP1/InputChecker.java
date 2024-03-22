package MP1;

import java.util.Scanner;

public class InputChecker {
    private Scanner userInput;

    public InputChecker(Scanner userInput) {
        this.userInput = userInput;
    }

    public int getIntInput() {
        // Declare variables
        int intInput = 0;
        boolean validInput = false;

        while (!validInput) { // Validates user input for integer values
            try {
                intInput = userInput.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================\n>> ");
                userInput.nextLine(); // Consumes buffer input
            }
        }

        return intInput;
    }
}
