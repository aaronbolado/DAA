package MP1;

import java.util.Scanner;

public class Queue {
    static Scanner input = new Scanner(System.in);
    QueueNode front; // Front of the queue
    QueueNode rear; // Rear of the queue
    int numElements;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.numElements = -1; // Indicates No Queue
    }

    public void createQueue() {
        if (numElements >= 0) {
            System.out.println("Error: Queue already exists.");
            return;
        }

        numElements = 0;
        System.out.println("Created New Empty Queue");
    }

    public void enqElement() {
        if (numElements == 0) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        System.out.print("Enter an Element to Enqueue: ");
        int element = input.nextInt();

        QueueNode newNode = new QueueNode(element);

        if (front == null) { // If queue is empty
            front = newNode;
        } else {
            rear.next = newNode; // Link the new node to the rear
        }

        rear = newNode; // Update the rear to the new node
        numElements++;

        System.out.println("Element Enqueued Successfully\n");
    }

    public void deqElement() {
        if (numElements == 0) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        if (front == null) { // Queue is empty
            System.out.println("Error: Queue is Empty\n");
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

    public void checkFront() {
        if (numElements == 0) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        if (front == null) { // Queue is empty
            System.out.println("Error: Queue is Empty\n");
            return;
        }

        System.out.println("Front Element: " + front.intData);
    }

    public void checkRear() {
        if (numElements == 0) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        if (rear == null) { // Queue is empty
            System.out.println("Error: Queue is Empty\n");
            return;
        }

        System.out.println("Rear Element: " + rear.intData);
    }

    public void displayQueue() {
        if (numElements == 0) {
            System.out.println("Error: Queue Does Not Exist. Create a Queue.");
            return;
        }

        if (front == null) { // Queue is empty
            System.out.println("Error: Queue is Empty\n");
            return;
        }

        QueueNode current = front;

        System.out.println("Queue Elements:");
        while (current != null) { // Traverse through queue
            System.out.print(current.intData + " ");
            current = current.next;
        }

        System.out.println();
    }
}
