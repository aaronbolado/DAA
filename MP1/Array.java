package MP1;

import java.util.*;

public class Array {
    static Scanner input = new Scanner(System.in);
    
    // Declare variables
    private int[] mainArray;
    private int arrSize = 20; // Tewmporary array size
    private int numElements;
    
    // Base Array
    public Array () { 
        mainArray = new int[arrSize];
        numElements = -1; // Indicates No Array
    }

    // Creates new array
    public void createArray () {
        mainArray = new int[arrSize];
        numElements = 0;
        System.out.println("Created New Empty Array\n");
    }

    public void insertElement () {
        if (numElements == -1) {
            System.out.println("Array Can't Be Found");

        } else if (numElements == arrSize) {
            System.out.println("Error: Array is Full\n");
        
        } else {
            System.out.print("Enter an Element to Insert: ");
            int element = input.nextInt();
           
            mainArray[numElements] = element;
            numElements++;
           
            System.out.println("Element Inserted Successfully\n");
        }
    }

    public void deleteElement () {
        if (numElements == -1) {
            System.out.println("Array Can't Be Found");

        } else if (numElements == 0) {
            System.out.println("Error: Array is Empty\n");

        } else {
            System.out.print("Enter an Element to Delete: ");
            int element = input.nextInt();

            for (int i = 0; i < numElements; i++) {
                if (mainArray[i] == element) {

                    for (int j = i; j < numElements; j++) {
                        mainArray[j] = mainArray[j+1];
                    }

                    mainArray[numElements] = 0;
                    
                    System.out.println("Element [" + element + "] Deleted from Array");
                    return;
                }
            }

            System.out.println("Error: Element Does Not Exist in Array\n");
        }
    }
    
    public void searchElement () {
        if (numElements == -1) {
            System.out.println("No Array Found\n");

        } else if (numElements == 0) {
            System.out.println("Error: Array is Empty\n");
    
        } else {
            System.out.print("Enter an Element to Search: ");
            int element = input.nextInt();
    
            for (int i = 0; i < numElements; i++) {
                if (mainArray[i] == element) {
                    System.out.println("Element [" + element + "] Found in Array");
                    System.out.println("Location at Index [" + i + "]\n");
                    return;
                }
            }

            System.out.println("Error: Element Does Not Exist in Array\n");
        }
    }
    
    public void displayArray () {
        if (numElements == -1) {
            System.out.println("No Array Found\n");

        } else if (numElements == 0) {
            System.out.println("Error: Array is Empty\n");
    
        } else {
            System.out.println("Elements in Array: ");
            for (int i = 0; i < numElements; i++) {
                System.out.print(mainArray[i] + " ");
            }
            System.out.print("\n");
        }
    }
}
