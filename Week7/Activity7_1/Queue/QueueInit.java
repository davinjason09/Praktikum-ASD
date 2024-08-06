import java.util.Arrays;

public class QueueInit {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueInit(int s) {
        maxSize = s;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(int j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        
        queueArray[++rear] = j;
        nItems++;
    }

    public int dequeue() {
        int temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }

        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void printQueue() {
        System.out.println(Arrays.toString(queueArray));
    }
}
