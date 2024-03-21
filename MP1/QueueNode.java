package MP1;

public class QueueNode {
    int intData;
    QueueNode prev;
    QueueNode next;

    // Constructor
    public QueueNode(int userInput) {
        this.intData = userInput;
        this.prev = null;
        this.next = null;
    }
}
