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
            // Display header         
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
                    arrayMenu();
                    break;
                case 2:
                    linkedListMenu();
                    break;
                case 3:
                    stackMenu();
                    break;
                case 4:
                    queueMenu();
                    break;
                case 5:
                    binaryTreeMenu();
                    break;
                case 6:
                    boolExit = confirmExit();
                    break;

                default: // Default case: Handles invalid input
                    System.out.println("Invalid input. Please enter a valid choice [1 - 6].");
                    break;
            }
            System.out.print("\n");
        }
        while (boolExit == false);

        // Program finishes
        System.out.print("\n\nExiting...\nThank you for using our program!\n\n");
    }  
    
    // Prints out header with specific format
    public static void printHeader (String headerString) {
        System.out.println("======"+ "=".repeat(headerString.length()));
        System.out.println("|| "+ headerString +" ||");
        System.out.println("======"+ "=".repeat(headerString.length()));
    }

    // Confirm exit method
    public static boolean confirmExit () {
        int intChoice;
    
        do {
            // Exit confirmation
            System.out.print("Are you sure you want to end transaction?" + "\n[1] - YES\n[2] - NO\nEnter the number of your choice: ");
            
            // Error checking for non-integer values
            while (!input.hasNextInt()){ 
                System.out.println("\nInvalid input. Please enter a valid integer.\n" + "\n=====================================================");
                System.out.print("\nAre you sure you want to end transaction?" + "\n[1] - YES\n[2] - NO\nEnter the number of your choice: ");
                input.next();
            }

            // Gets and checks if integer is a valid choice
            intChoice = input.nextInt();

            // Displays error message for integers other than [1] or [2]
            if (intChoice != 1 && intChoice != 2) 
                System.out.println("\nInvalid input. Please enter a valid integer [1 or 2].\n" + "\n=====================================================\n");
        } while (intChoice != 1 && intChoice != 2);

        // Exits program if input is [1]
        return (intChoice == 1) ? true : false ;
    }

    public static void arrayMenu (){
        // Declaring variables for the menu
        int intMenuState;
        boolean boolExit = false;

        // Instantiate Array Class
        Array arrayObject = new Array();

        // Display header         
        printHeader("Array Data Structure");

        // Main menu
        do{

            // Initial text for introduction
            System.out.println("\n[1] Create an Empty Array\n" + //
                                "[2] Insert elements into the Array\n" + //
                                "[3] Delete an element in the Array\n" + //
                                "[4] Search for an element in the Array\n" + //
                                "[5] Display the Array\n" + //
                                "[0] RETURN TO MAIN MENU");
            
            // Prompting user for string toolkit choice
            System.out.print("\nEnter the number of your choice [0 - 5]: ");
            
            // Error checking for non-integer values
            while (!input.hasNextInt()){ 
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================");
                System.out.print("\nEnter the number of your choice [0 - 5]: ");
                input.next();
            }

            // Gets input if integer
            intMenuState = input.nextInt();
            System.out.println("\n=====================================================\n");
            
            // Process the user's choice based on intMenuState
            switch (intMenuState) {
                case 1:
                    arrayObject.createArray();
                    break;
                case 2:
                    arrayObject.insertElement();
                    break;
                case 3:
                    arrayObject.deleteElement();
                    break;
                case 4:
                    arrayObject.searchElement();
                    break;
                case 5:
                    arrayObject.displayArray();
                    break;
                case 0:
                    boolExit = confirmExit();
                    break;

                default: // Default case: Handles invalid input
                    System.out.println("Invalid input. Please enter a valid choice [0 - 5].");
                    break;
            }
        }
        while (boolExit == false);
    }
    
    public static void linkedListMenu (){
        // Declaring variables for the menu
        int intMenuState;
        boolean boolExit = false;

        // Instantiate Array Class
        LinkedList linkedListObject = new LinkedList();

        // Display header         
        printHeader("Linked List Data Structure");

        // Main menu
        do{

            // Initial text for introduction
            System.out.println("\n[1] Create an Empty Linked List\n" + //
                                "[2] Insert elements into the Linked List\n" + //
                                "[3] Delete an element in the Linked List\n" + //
                                "[4] Search for an element in the Linked List\n" + //
                                "[5] Display the Linked List\n" + //
                                "[0] RETURN TO MAIN MENU");
            
            // Prompting user for string toolkit choice
            System.out.print("\nEnter the number of your choice [0 - 5]: ");
            
            // Error checking for non-integer values
            while (!input.hasNextInt()){ 
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================");
                System.out.print("\nEnter the number of your choice [0 - 5]: ");
                input.next();
            }

            // Gets input if integer
            intMenuState = input.nextInt();
            System.out.println("\n=====================================================\n");
            
            // Process the user's choice based on intMenuState
            switch (intMenuState) {
                case 1:
                    linkedListObject.createLinkedList();
                    break;
                case 2:
                    linkedListObject.insertElement();
                    break;
                case 3:
                    linkedListObject.deleteElement();
                    break;
                case 4:
                    linkedListObject.searchElement();
                    break;
                case 5:
                    linkedListObject.displayLinkedList();
                    break;
                case 0:
                    boolExit = confirmExit();
                    break;

                default: // Default case: Handles invalid input
                    System.out.println("Invalid input. Please enter a valid choice [0 - 5].");
                    break;
            }
        }
        while (boolExit == false);
    }

    public static void stackMenu (){
        // Declaring variables for the menu
        int intMenuState;
        boolean boolExit = false;

        Stack stackObject = new Stack();

        // Display header         
        printHeader("Stack Data Structure");

        // Main menu
        do{

            // Initial text for introduction
            System.out.println("\n[1] Create an Empty Stack\n" + //
                                "[2] PUSH element in the Stack\n" + //
                                "[3] POP element in the Stack\n" + //
                                "[4] CHANGE specific element in the Stack\n" + //
                                "[5] Display the Stack\n" + //
                                "[0] RETURN TO MAIN MENU");
            
            // Prompting user for string toolkit choice
            System.out.print("\nEnter the number of your choice [0 - 5]: ");
            
            // Error checking for non-integer values
            while (!input.hasNextInt()){ 
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================");
                System.out.print("\nEnter the number of your choice [0 - 5]: ");
                input.next();
            }

            // Gets input if integer
            intMenuState = input.nextInt();
            System.out.println("\n=====================================================\n");
            
            // Process the user's choice based on intMenuState
            switch (intMenuState) {
                case 1:
                    stackObject.createStack();
                    break;
                case 2:
                    stackObject.pushElement();
                    break;
                case 3:
                    stackObject.popElement();
                    break;
                case 4:
                    stackObject.changeElement();
                    break;
                case 5:
                    stackObject.displayStack();
                    break;
                case 0:
                    boolExit = confirmExit();
                    break;

                default: // Default case: Handles invalid input
                    System.out.println("Invalid input. Please enter a valid choice [0 - 5].");
                    break;
            }
        }
        while (boolExit == false);
    }

    public static void queueMenu (){
        // Declaring variables for the menu
        int intMenuState;
        boolean boolExit = false;

        Queue queueObject = new Queue();

        // Display header         
        printHeader("Queue Data Structure");

        // Main menu
        do{

            // Initial text for introduction
            System.out.println("\n[1] Create an Empty Queue\n" + //
                                "[2] ENQUEUE element in the Queue\n" + //
                                "[3] DEQUEUE element in the Queue\n" + //
                                "[4] Check FRONT\n" + //
                                "[5] Check REAR\n" + //
                                "[6] Display Queue\n" + //
                                "[0] RETURN TO MAIN MENU");
            
            // Prompting user for string toolkit choice
            System.out.print("\nEnter the number of your choice [0 - 6]: ");
            
            // Error checking for non-integer values
            while (!input.hasNextInt()){ 
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================");
                System.out.print("\nEnter the number of your choice [0 - 6]: ");
                input.next();
            }

            // Gets input if integer
            intMenuState = input.nextInt();
            System.out.println("\n=====================================================\n");
            
            // Process the user's choice based on intMenuState
            switch (intMenuState) {
                case 1:
                    queueObject.createQueue();
                    break;
                case 2:
                    queueObject.enqElement();
                    break;
                case 3:
                    queueObject.deqElement();
                    break;
                case 4:
                    queueObject.checkFront();
                    break;
                case 5:
                    queueObject.checkRear();
                    break;
                case 6:
                    queueObject.displayQueue();
                    break;
                case 0:
                    boolExit = confirmExit();
                    break;

                default: // Default case: Handles invalid input
                    System.out.println("Invalid input. Please enter a valid choice [0 - 6].");
                    break;
            }
        }
        while (boolExit == false);
    }

    public static void binaryTreeMenu (){
        // Declaring variables for the menu
        int intMenuState;
        boolean boolExit = false;

        BinaryTree btreeObject = new BinaryTree();

        // Main menu
        do{
            // Display header         
            printHeader("Binary Tree Data Structure");

            // Initial text for introduction
            System.out.println("\n[1] Create an Empty Binary Tree\n" + //
                                "[2] Insert element into the Binary Tree\n" + //
                                "[3] Delete element in the Binary Tree\n" + //
                                "[4] Display Binary Tree\n" + //
                                "[5] Display Tree Structure\n" + //
                                "[0] RETURN TO MAIN MENU");
            
            // Prompting user for string toolkit choice
            System.out.print("\nEnter the number of your choice [0 - 5]: ");
            
            // Error checking for non-integer values
            while (!input.hasNextInt()){ 
                System.out.println("\nInvalid input. Please enter a valid integer.");
                System.out.println("\n=====================================================");
                System.out.print("\nEnter the number of your choice [0 - 5]: ");
                input.next();
            }

            // Gets input if integer
            intMenuState = input.nextInt();
            System.out.println("\n=====================================================\n");
            
            // Process the user's choice based on intMenuState
            switch (intMenuState) {
                case 1:
                    btreeObject.createBinaryTree();
                    break;
                case 2:
                    btreeObject.insertElement();
                    break;
                case 3:
                    btreeObject.deleteElement();
                    break;
                case 4:
                    btreeObject.displayBinaryTree();
                    break;
                case 5:
                    btreeObject.displayTreeStructure();
                    break;
                case 0:
                    boolExit = confirmExit();
                    break;

                default: // Default case: Handles invalid input
                    System.out.println("Invalid input. Please enter a valid choice [0 - 5].");
                    break;
            }
        }
        while (boolExit == false);
    }
}