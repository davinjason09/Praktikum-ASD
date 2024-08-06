public class LinkListInit {
    Node first;

    // Constructor
    LinkListInit() {
        first = null;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    // Insert data from the front
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
    }

    // Insert data from the back
    public void insertLast(int data) {
        if (isEmpty())
            insertFirst(data);
        else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            
            temp.next = new Node(data);
        }
    }

    // Delete the first data
    public void deleteFirst() {
        Node temp = first;
        first = first.next;
        temp.next = null;
    }

    // Delete the last data
    public void deleteLast() {
        Node temp = first;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Print the list
    public void displayLink() {
        System.out.print("List (first --> last) : ");
        Node current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
