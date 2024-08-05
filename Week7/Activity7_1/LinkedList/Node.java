public class Node {
    int data;
    Node next;

    //Constructor
    Node(int data) {
        this.data = data;
    }

    //Print data
    public void displayLink() {
        System.out.printf("{%d}", this.data);
    }
}
