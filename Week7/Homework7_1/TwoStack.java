import java.util.Scanner;
import java.io.IOException;

public class TwoStack {
    public static void main(String[] args) throws IOException {
        int stackSize;
        int stackNum;
        int numChoice = 0;
        int numTemp;

        Scanner in = new Scanner(System.in);

        System.out.print("How many integer? ");
        stackSize = in.nextInt();

        TwoStackInit twoStack = new TwoStackInit(stackSize);

        while (numChoice != 5) {
            System.out.println("\n1: PushA\n2: PopA\n3: PushB\n4: PopB\n5: Exit");
            System.out.print("Enter command: ");
            numChoice = in.nextInt();

            switch (numChoice) {
                case 1:
                    if (twoStack.isFull()) System.out.println("Stack is full!");
                    else {
                        System.out.print("Enter number: ");
                        stackNum = in.nextInt();
                        twoStack.pushA(stackNum);
                        twoStack.printStack();
                    }
                    break;
                case 2:
                    if (twoStack.isEmpty()) System.out.println("Stack is empty!");
                    else {
                        numTemp = twoStack.popA();
                        System.out.println((numTemp == -1)? "Stack A is empty!" : "Popped number = " + numTemp);
                    }
                    break;
                case 3:
                    if (twoStack.isFull()) System.out.println("Stack is full!");
                    else {
                        System.out.print("Enter number: ");
                        stackNum = in.nextInt();
                        twoStack.pushB(stackNum);
                        twoStack.printStack();
                    }
                    break;
                case 4:
                    if (twoStack.isEmpty()) System.out.println("Stack is empty!");
                    else {
                        numTemp = twoStack.popB();
                        System.out.println((numTemp == -1)? "Stack B is empty!" : "Popped number = " + numTemp);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }

        in.close();
    }
}
