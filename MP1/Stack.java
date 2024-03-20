package MP1;

import java.util.*;

public class Stack {
    static Scanner input = new Scanner(System.in);
    
    // Declare variables
    private int[] mainArray;
    private int arrSize = 5; // Temporary array size
    private int top; // Pointer to top of the stack
    
    // Constructor
    public Stack () {
        this.mainArray = new int[arrSize];
        this.top = -1; // Stack is empty
    }

    // Method to create a new empty stack
    public void createStack() {
        if (top == -1) {
            System.out.println("Error: Stack already exists.");
            return;
        }
        mainArray = new int[arrSize];
        top = -1; // Reset top pointer to indicate empty stack
        System.out.println("Created a new empty stack.");
    }

    // PUSH operation to insert an element into the stack
    public void pushElement() {
        if (top == arrSize - 1) {
            System.out.println("Error: Stack Overflow. Cannot push more elements.");
        } else {
            System.out.print("Enter an Element to Push: ");
            int element = input.nextInt();
            top++;
            mainArray[top] = element;
            System.out.println("Element " + element + " pushed into the stack.");
        }
    }

    // POP operation to remove an element from the stack
    public void popElement() {
        if (top == -1) {
            System.out.println("Error: Stack Underflow. Cannot pop from an empty stack.");
        } else {
            int poppedElement = mainArray[top];
            top--;
            System.out.println("Element " + poppedElement + " popped from the stack.");
        }
    }

    // CHANGE operation to modify a specific element in the stack
    public void changeElement() {
        if (top == -1) {
            System.out.println("Error: Stack is Empty. Cannot change elements.");
        } else {
            System.out.print("Enter the index of the element to change: ");
            int index = input.nextInt();
            if (index < 0 || index > top) {
                System.out.println("Error: Invalid index.");
                return;
            }
            System.out.print("Enter the new value: ");
            int newValue = input.nextInt();
            mainArray[index] = newValue;
            System.out.println("Element at index " + index + " changed to " + newValue);
        }
    }

    // Display the elements in the stack
    public void displayStack() {
        if (top == -1) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println("Stack Elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(mainArray[i] + " ");
            }
            System.out.println(); // New line for formatting
        }
    }
}
