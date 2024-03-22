package MP1;

import java.util.Scanner;

public class InputChecker {
    private Scanner userInput;

    public InputChecker(Scanner userInput) {
        this.userInput = userInput;
    }

    public int getIntInput() {
        int intInput = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("\nEnter the number of your choice [1 - 6]: ");

            try {
                intInput = userInput.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================");
                userInput.nextLine(); // Clear the input buffer
            }
        }

        return intInput;
    }

}
