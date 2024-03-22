package MP1;

import java.util.Scanner;

public class Queue {
    static Scanner input = new Scanner(System.in);
    InputChecker inputChecker = new InputChecker(input);

    // Declare Variables
    QueueNode front; // Front of the queue
    QueueNode rear; // Rear of the queue
    int numElements; // Counts number of elements

    // Base Queue
    public Queue() {
        this.front = null;
        this.rear = null;
        this.numElements = -1; // Indicates No Queue
    }

    // Method to create a new empty queue
    public void createQueue() {
        if (numElements >= 0) { 
            System.out.println("Error: A Queue already exists.");
            return;
        }

        numElements = 0;
        System.out.println("Created New Empty Queue");
    }

    // Method to enqueue an element into the queue
    public void enqElement() {
        if (numElements == -1) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        System.out.print("Enter an Element to Enqueue: ");
        int element = inputChecker.getIntInput();

        QueueNode newNode = new QueueNode(element);

        if (front == null) { // If queue is empty
            front = newNode;
        } else {
            rear.next = newNode; // Link the new node to the rear
        }

        rear = newNode; // Update the rear to the new node
        numElements++;

        System.out.println("Element Enqueued Successfully.");
    }

    // Method to dequeue an element from the queue
    public void deqElement() {
        if (numElements == -1) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        if (front == null) { // Queue is empty
            System.out.println("Error: Queue is Empty.");
            return;
        }

        int dequeuedElement = front.intData;
        front = front.next; // Move front to the next element

        if (front == null) { // If queue becomes empty
            rear = null;
        }

        numElements--;
        System.out.println("Dequeued Element: " + dequeuedElement);
    }

    // Method to check the front element of the queue
    public void checkFront() {
        if (numElements == -1) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        if (front == null) { // Queue is empty
            System.out.println("Error: Queue is Empty.");
            return;
        }

        System.out.println("Front Element: " + front.intData);
    }

    // Method to check the rear element of the queue
    public void checkRear() {
        if (numElements == -1) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }
        
        if (rear == null) { // Queue is empty
            System.out.println("Error: Queue is Empty.");
            return;
        }

        System.out.println("Rear Element: " + rear.intData);
    }

    // Method to display the elements in the queue
    public void displayQueue() {
        if (numElements == -1) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        if (front == null) { // Queue is empty
            System.out.println("Error: Queue is Empty.");
            return;
        }

        QueueNode current = front;

        System.out.print("Queue Elements: ");
        while (current != null) { // Traverse through queue
            System.out.print(current.intData + " ");
            current = current.next;
        }

        System.out.println();
    }
}
