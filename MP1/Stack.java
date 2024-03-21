package MP1;

import java.util.*;

public class Stack {
    static Scanner input = new Scanner(System.in);
    
    // Declare variables
    private int[] stackArray;
    private int stackSize = 5; // Temporary array size
    private int numElements; // Counts number of elements
    
    // Constructor
    public Stack () {
        this.stackArray = new int[stackSize];
        this.numElements = -1; // Indicates No Stack
    }

    // Method to create a new empty stack
    public void createStack() {
        if (numElements >= 0) {
            System.out.println("Error: Stack already exists.");
            return;
        }
        
        stackArray = new int[stackSize];
        numElements = 0; // Reset numElements pointer to indicate empty stack
        System.out.println("Created New Empty Stack.");
    }

    // PUSH operation to insert an element into the stack
    public void pushElement() {
        if (numElements == -1) {
            System.out.println("Error: Stack Does Not Exist. Create a Stack.");
            return;
        }

        if (numElements == stackSize) {
            System.out.println("Error: STACKOVERFLOW. Cannot push more elements.");
        } else {
            System.out.print("Enter an Element to Push: ");
            int element = input.nextInt();

            numElements++;
            stackArray[numElements-1] = element;
            System.out.println("Element " + element + " pushed into the stack.");
        }
    }

    // POP operation to remove an element from the stack
    public void popElement() {
        if (numElements == -1) {
            System.out.println("Error: Stack Does Not Exist. Create a Stack.");
            return;
        }

        if (numElements == 0) {
            System.out.println("Error: STACKUNDERFLOW. Cannot pop from an empty stack.");
        } else {
            int poppedElement = stackArray[numElements - 1];
            numElements--;
            System.out.println("Element " + poppedElement + " popped from the stack.");
        }
    }

    // CHANGE operation to modify a specific element in the stack
    public void changeElement() {
        if (numElements == -1) {
            System.out.println("Error: Stack Does Not Exist. Create a Stack.");
            return;
        }
        
        if (numElements == 0) {
            System.out.println("Error: Stack is Empty. Cannot change elements.");

        } else {
            System.out.print("Enter an element to change: ");
            int element = input.nextInt();
            
            for (int i = numElements - 1; i >= 0; i--) { // Starts from the top of the stack
                if (stackArray[i] == element) {
                    System.out.print("Enter the new value: ");
                    int newValue = input.nextInt();
        
                    stackArray[i] = newValue;
                    System.out.println("Element at index " + i + " changed to " + newValue);
                    return;
                }
            }
            
            System.out.println("Error: Element To Change Does Not Exist in Stack\n");            
        }
    }

    // Display the elements in the stack
    public void displayStack() {
        if (numElements == 0) {
            System.out.println("Error: Stack is Empty.");

        } else {
            System.out.println("Elements in Stack: ");
            for (int i = numElements - 1; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}
