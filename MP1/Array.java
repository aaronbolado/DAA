package MP1;

import java.util.*;

public class Array {
    static Scanner input = new Scanner(System.in);
    
    // Declare variables
    private int[] mainArray;
    private int arrSize = 10;
    private int numElements;
    
    // Base Array
    public Array () { 
        mainArray = new int[arrSize];
        numElements = 0;
    }

    // Creates new array
    public void createArray () {
        mainArray = new int[arrSize];
        numElements = 0;
        System.out.println("Created New Empty Array");
    }

    public void insertElement () {
        if (numElements == arrSize) {
            System.out.println("Error: Array is Full");
        
        } else {
            System.out.print("Enter an Element to Insert: ");
            int element = input.nextInt();
           
            mainArray[numElements] = element;
            numElements++;
           
            System.out.println("Element Inserted Successfully.");
        }
    }

    public void deleteElement () {
        if (numElements == 0) {
            System.out.println("No Element to Delete");

        } else {
            System.out.println("Enter an Element to Delete: ");
            int element = input.nextInt();

            for (int i = 0; i < numElements; i++) {
                if (mainArray[i] == element) {

                    for (int j = i; j < numElements; j++) {
                        mainArray[j] = mainArray[j+1];
                    }

                    mainArray[numElements] = 0;
                    
                    System.out.println("Element [" + element + "] Deleted from Array");
                
                } else {
                    System.out.println("Error: Element Does Not Exist in Array");
                }
            }
        }
    }

    public void searchElement () {

    }

    public void displayArray () {

    }
}
