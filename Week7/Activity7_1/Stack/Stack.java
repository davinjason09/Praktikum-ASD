import java.io.IOException;
import java.util.Scanner;

public class Stack {
    public static void main(String[] args) throws IOException {
        int stackSize;
        int stackNum;

        Scanner in = new Scanner(System.in);

        System.out.print("How many integer? ");
        stackSize = in.nextInt();

        StackInit theStack = new StackInit(stackSize);

        for (int i = 0; i < stackSize; i++) {
            System.out.print("Enter number : ");
            stackNum = in.nextInt();
            theStack.push(stackNum);
        }
        
        theStack.printStack();

        in.close();

        while (!theStack.isEmpty()) {
            double value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }

        System.out.println();
    }
}
