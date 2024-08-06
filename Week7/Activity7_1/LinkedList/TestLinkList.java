import java.util.Scanner;

public class TestLinkList {
    public static void main(String[] args) {
        LinkListInit theList1 = new LinkListInit();
        LinkListInit theList2 = new LinkListInit();

        // Define the list size
        Scanner in = new Scanner(System.in);
        int nodeNum1, nodeNum2, tempNum;

        System.out.print("First list size? ");
        nodeNum1 = in.nextInt();

        // Initializing and displaying the list
        for (int i = 0; i < nodeNum1; i++) {
            System.out.print("Insert number : ");
            tempNum = in.nextInt();
            theList1.insertLast(tempNum);
        }
        theList1.displayLink();

        System.out.print("Second list size? ");
        nodeNum2 = in.nextInt();

        for (int i = 0; i < nodeNum2; i++) {
            System.out.print("Insert number : ");
            tempNum = in.nextInt();
            theList2.insertFirst(tempNum);
        }
        theList2.displayLink();

        in.close();

        // Deleting elements of the list
        System.out.println("\nDeleting the first node of the first list");
        theList1.deleteFirst();
        theList1.displayLink();

        System.out.println("\nDeleting the last node of the second list");
        theList2.deleteLast();
        theList2.displayLink();
    }
}
