package MP1;

public class QueueNode {
    int data;
    QueueNode front;
    QueueNode rear;

    // Constructor
    public QueueNode(int data) {
        this.data = data;
        this.front = null;
        this.rear = null;
    }
}
