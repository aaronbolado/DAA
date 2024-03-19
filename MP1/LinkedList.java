package MP1;

import java.util.*;

public class LinkedList {
    static Scanner input = new Scanner(System.in);
    Node head; // head of list
    int numElements;

    public LinkedList () {
        this.head = null;
        this.numElements = -1; // Indicates Empty List
    }

    public void createLinkedList () {
        numElements = 0;
    }

    public void insertElement () {
        if (numElements == -1) {
            System.out.println("Error: Linked List Does Not Exist. Create a Linked List.");
            return;

        }

        System.out.print("Enter an Element to Insert: ");
        int element = input.nextInt();

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
        int element = input.nextInt();

        if (head.intData == element) { // Element Found at the Head
            head = head.next;
            System.out.println("Element [" + element + "] Deleted from Linked List");
        }

        Node prev = head; // Track previous node for linking after deleting
        Node current = head.next; 

        // Traversing through linked list
        while (current != null) { 
            if (current.intData == element) {
                prev.next = current.next;
                System.out.println("Element [" + element + "] Deleted from Linked List");
            }

            // Proceed to the next nodes
            prev = current;
            current = current.next;
        }

        System.out.println("Error: Element Does Not Exist in Linked List\n");
    }

    public boolean searchElement(int data) {
        if (numElements == -1) {
            System.out.println("Error: Linked List Does Not Exist. Create a Linked List.");

        }

        Node current = head;
        while (current != null) {
            if (current.intData == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayLinkedList() {
        if (numElements == -1) {
            System.out.println("Error: Linked List Does Not Exist. Create a Linked List.");

        }
        
        Node current = head;
        while (current != null) {
            System.out.print(current.intData + " ");
            current = current.next;
        }
        System.out.println();
    }
}
