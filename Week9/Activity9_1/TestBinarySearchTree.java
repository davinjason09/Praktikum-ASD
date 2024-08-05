public class TestBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.insert(3);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.insert(8);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.insert(2);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.insert(4);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.insert(6);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.insert(7);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());

        bst.search(2);
        bst.search(9);
        System.out.println();

        bst.delete(8);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.delete(6);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.delete(7);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
        bst.delete(2);
        System.out.println(bst);
        bst.prettyPrint(bst.getRoot(), bst.getLevel(), bst.getMaxWordLength());
    }
}
