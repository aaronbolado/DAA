package MP1;

import java.util.*;

public class LinkedList {
    static Scanner input = new Scanner(System.in);
    InputChecker inputChecker = new InputChecker(input);

    // Declare Variables
    Node head; // head of list
    int numElements; // Counts number of elements

    // Base Linked List
    public LinkedList () {
        this.head = null;
        this.numElements = -1; // Indicates Empty List
    }

    // Method to create a new empty Linked List
    public void createLinkedList () {
        if (numElements >= 0) { 
            System.out.println("Error: A Linked List already exists.");
            return;
        }

        numElements = 0; // Reset numElements pointer to indicate empty Linked List
        System.out.println("Created New Empty Linked List");
    }

    public void insertElement () {
        if (numElements == -1) {
            System.out.println("Error: Linked List Does Not Exist. Create a Linked List.");
            return;
        }

        System.out.print("Enter an Element to Insert: ");
        int element = inputChecker.getIntInput();

        Node newNode = new Node(element);

        if (head == null) { // If linked list is empty
            head = newNode; 
            System.out.println("Element Inserted Successfully\n");

        } else {
            Node temp = head; 

            while (temp.next != null) { // Traverses linked list to reach the tail
                temp = temp.next;
            }

            temp.next = newNode; // Inserts node at the tail of the linked list
            numElements++;

            System.out.println("Element Inserted Successfully\n");
        }
    }

    public void deleteElement () {
        if (numElements == -1) {
            System.out.println("Error: Linked List Does Not Exist. Create a Linked List.");
            return;
        }
        
        if (head == null) { // Linked list is empty
            System.out.println("Error: Linked List is Empty\n");
            return;
        }

        System.out.print("Enter an Element to Delete: ");
        int element = inputChecker.getIntInput();

        if (head.intData == element) { // Element Found at the Head
            head = head.next;
            numElements--;
            System.out.println("Element [" + element + "] Deleted from Linked List");
            return;
        }

        Node prev = head; // Track previous node for linking after deleting
        Node current = head.next; 

        // Traversing through linked list
        while (current != null) { 
            if (current.intData == element) {
                prev.next = current.next;
                numElements--;
                System.out.println("Element [" + element + "] Deleted from Linked List");
                return;
            }

            // Proceed to the next nodes
            prev = current;
            current = current.next;
        }

        System.out.println("Error: Element Does Not Exist in Linked List\n");
    }

    public void searchElement () {
        if (numElements == -1) {
            System.out.println("Error: Linked List Does Not Exist. Create a Linked List.");
            return;
        }

        if (head == null) { // Linked list is empty
            System.out.println("Error: Linked List is Empty\n");
            return;
        }

        System.out.print("Enter an Element to Search: ");
        int element = inputChecker.getIntInput();

        Node current = head;
        int intIndex = 0;

        while (current != null) { // Traverse through linked list
            if (current.intData == element) {
                System.out.println("Element [" + element + "] Found in Linked List");
                System.out.println("Location at Index [" + intIndex + "]\n");
                return;
            }

            current = current.next;
            intIndex++;
        }

        System.out.println("Error: Element Does Not Exist in Linked List\n");
    }

    public void displayLinkedList() {
        if (numElements == -1) {
            System.out.println("Error: Linked List Does Not Exist. Create a Linked List.");
            return;
        }

        if (head == null) { // Linked list is empty
            System.out.println("Error: Linked List is Empty\n");
            return;
        }
        
        Node current = head;

        while (current != null) { // Traverse through linked list
            System.out.print(current.intData + " ");
            current = current.next;
        }

        System.out.println();
    }
}
