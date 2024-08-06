public class TraverseBinaryTree {
    public static boolean printLevel(BinaryTreeNode t, int level) {
        if (t == null)
            return false;

        if (level == 0) {
            System.out.printf("Visited node %s%n", t.label);
            return true;
        }

        boolean left = printLevel(t.left, level - 1);
        boolean right = printLevel(t.right, level - 1);
        return left || right;
    }

    public static void traversePreorder(BinaryTreeNode t) {
        if (t == null)
            return;

        System.out.printf("Visited node %s%n", t.label);
        traversePreorder(t.left);
        traversePreorder(t.right);
    }

    public static void traverseInorder(BinaryTreeNode t) {
        if (t == null)
            return;

        traverseInorder(t.left);
        System.out.printf("Visited node %s%n", t.label);
        traverseInorder(t.right);
    }

    public static void traversePostorder(BinaryTreeNode t) {
        if (t == null)
            return;
            
        traversePostorder(t.left);
        traversePostorder(t.right);
        System.out.printf("Visited node %s%n", t.label);
    }

    public static void traverseLevelorder(BinaryTreeNode t) {
        int level = 0;

        while (printLevel(t, level)) {
            level++;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode tree, p, q;
        p = new BinaryTreeNode("c", null, null);
        p = new BinaryTreeNode("b", p, null);
        q = new BinaryTreeNode("d", null, null);
        tree = new BinaryTreeNode("a", p, q);

        System.out.println(tree);

        System.out.println("Preorder traversal:");
        traversePreorder(tree);

        System.out.println("Inorder traversal:");
        traverseInorder(tree);

        System.out.println("Postorder traversal:");
        traversePostorder(tree);

        System.out.println("Level order traversal:");
        traverseLevelorder(tree);
    }
}
