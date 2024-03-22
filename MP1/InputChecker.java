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
            try {
                intInput = userInput.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================\n>> ");
                userInput.nextLine(); // Consume the invalid token
            }
        }

        return intInput;
    }

}
