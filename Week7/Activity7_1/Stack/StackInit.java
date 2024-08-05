import java.util.Arrays;

public class StackInit {
    private final int maxSize;
    private int[] stackArray;
    private int top;

    public StackInit(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void printStack() {
        System.out.println(Arrays.toString(stackArray));
    }
}
