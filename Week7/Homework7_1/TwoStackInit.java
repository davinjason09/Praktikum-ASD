import java.util.Arrays;

public class TwoStackInit {
    private final int maxSize;
    private int[] stackArray;
    private int nItemsA;
    private int nItemsB;

    public TwoStackInit(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        nItemsA = nItemsB = 0;
    }

    public void pushA(int j) {
        stackArray[nItemsA++] = j;
    }

    public int popA() {
        if (nItemsA == 0) return -1;
        return stackArray[--nItemsA];
    }

    public void pushB(int j) {
        stackArray[maxSize - nItemsB++ - 1] = j;
    }

    public int popB() {
        if (nItemsB == 0) return -1;
        return stackArray[maxSize - --nItemsB - 1];
    }

    public boolean isEmpty() {
        return ((nItemsA + nItemsB) == 0);
    }

    public boolean isFull() {
        return ((nItemsA + nItemsB) == maxSize);
    }

    public void printStack() {
        System.out.println(Arrays.toString(stackArray));
    }
}
