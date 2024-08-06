import java.io.IOException;
import java.util.Scanner;

public class FrontRearQueue {
    public static void main(String[] args) throws IOException {
        int queueSize;
        int numTemp;
        int numChoice = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        queueSize = in.nextInt();

        FrontRearQueueInit theQueue = new FrontRearQueueInit(queueSize);

        while (numChoice != 4) {
            System.out.println("\n1: Enqueue\n2: DequeueFront\n3: DequeueRear\n4: Exit");
            System.out.print("Enter command: ");
            numChoice = in.nextInt();

            switch (numChoice) {
                case 1:
                    if (theQueue.isFull())
                        System.out.println("Queue is full");
                    else {
                        System.out.print("Enter number: ");
                        numTemp = in.nextInt();
                        theQueue.enqueue(numTemp);
                        theQueue.printQueue();
                    }
                    break;
                case 2:
                    if (theQueue.isEmpty())
                        System.out.println("Queue is empty");
                    else {
                        numTemp = theQueue.dequeueFront();
                        System.out.println("Dequeued number: " + numTemp);
                    }
                    break;
                case 3:
                    if (theQueue.isEmpty())
                        System.out.println("Queue is empty");
                    else {
                        numTemp = theQueue.dequeueRear();
                        System.out.println("Dequeued number: " + numTemp);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }

        in.close();
    }
}
