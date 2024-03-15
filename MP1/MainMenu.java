package MP1;

import java.util.*;

class MainMenu {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Declaring variables for the menu
        int intMenuState;
        boolean boolExit = false;

        // Introduction 
        printHeader("Author: Aaron John C. Bolado | BSCS 2-5");

        // Main menu
        do{
            // Print header         
            printHeader("Program: Data Structure Toolkit");

            // Initial text for introduction
            System.out.println("\n[1] - Array\n[2] - Linked List\n[3] - Stack\n[4] - Queue\n[5] - Binary Tree\n[6] - Exit Program");
            
            // Prompting user for string toolkit choice
            System.out.print("\nEnter the number of your choice [1 - 6]: ");
            
            // Error checking for non-integer values
            while (!input.hasNextInt()){ 
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================");
                System.out.print("\nEnter the number of your choice [1 - 6]: ");
                input.next();
            }

            // Gets input if integer
            intMenuState = input.nextInt();
            System.out.println("\n=====================================================\n");
            
            // Process the user's choice based on intMenuState
            switch (intMenuState) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;

                default: // Default case: Handles invalid input
                    System.out.println("Invalid input. Please enter a valid choice [1 - 6].");
                    break;
            }
        }
        while (boolExit == false);

        // Program finishes
        System.out.print("\n\nExiting...\nThank you for using our program!\n\n");
    }  

    public static int menuChoice () {
        
        return 1;
    }
    
    // Prints out header with specific format
    public static void printHeader (String headerString) {
        System.out.println("======"+ "=".repeat(headerString.length()));
        System.out.println("|| "+ headerString +" ||");
        System.out.println("======"+ "=".repeat(headerString.length()));
    }

    public static void arrayMenu (){

    }
}