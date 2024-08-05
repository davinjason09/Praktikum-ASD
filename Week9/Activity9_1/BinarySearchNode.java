public class BinarySearchNode {
    Integer data;
    BinarySearchNode left;
    BinarySearchNode right;

    BinarySearchNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return "[" + data + ", " + left + ", " + right + "]";
    }
}
