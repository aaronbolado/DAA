package MP1;

import java.util.*;

public class Stack {
    static Scanner input = new Scanner(System.in);
    
    // Declare variables
    private int[] stackArray;
    private int stackSize = 5; // Temporary array size
    private int topElement; // Pointer to top of the stack
    
    // Constructor
    public Stack () {
        this.stackArray = new int[stackSize];
        this.topElement = -1; // Stack is empty
    }

    // Method to create a new empty stack
    public void createStack() {
        if (topElement == -1) {
            System.out.println("Error: Stack already exists.");
            return;
        }
        
        stackArray = new int[stackSize];
        topElement = -1; // Reset topElement pointer to indicate empty stack
        System.out.println("Created a new empty stack.");
    }

    // PUSH operation to insert an element into the stack
    public void pushElement() {
        if (topElement == stackSize - 1) {
            System.out.println("Error: Stack Overflow. Cannot push more elements.");
        } else {
            System.out.print("Enter an Element to Push: ");
            int element = input.nextInt();
            topElement++;
            stackArray[topElement] = element;
            System.out.println("Element " + element + " pushed into the stack.");
        }
    }

    // POP operation to remove an element from the stack
    public void popElement() {
        if (topElement == -1) {
            System.out.println("Error: Stack Underflow. Cannot pop from an empty stack.");
        } else {
            int poppedElement = stackArray[topElement];
            topElement--;
            System.out.println("Element " + poppedElement + " popped from the stack.");
        }
    }

    // CHANGE operation to modify a specific element in the stack
    public void changeElement() {
        if (topElement == -1) {
            System.out.println("Error: Stack is Empty. Cannot change elements.");
        } else {
            System.out.print("Enter the index of the element to change: ");
            int index = input.nextInt();
            if (index < 0 || index > topElement) {
                System.out.println("Error: Invalid index.");
                return;
            }
            System.out.print("Enter the new value: ");
            int newValue = input.nextInt();
            stackArray[index] = newValue;
            System.out.println("Element at index " + index + " changed to " + newValue);
        }
    }

    // Display the elements in the stack
    public void displayStack() {
        if (topElement == -1) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println("Stack Elements: ");
            for (int i = topElement; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println(); // New line for formatting
        }
    }
}
