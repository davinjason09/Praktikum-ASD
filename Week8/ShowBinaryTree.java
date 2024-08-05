public class ShowBinaryTree {
    private static String getSpace(int n) {
        String s = "";
        for (int i = 0; i < n; i++) s += " ";
        return s;
    }

    public static String prettyPrint(BinaryTreeNode node) {
        return prettyPrint(0, node);
    }

    public static String prettyPrint(int n, BinaryTreeNode node) {
        if (node == null) return getSpace(n) + "null\n";
        String s = "";
        s += prettyPrint(n+2, node.right);
        s += getSpace(n) + node.label + "\n";
        s += prettyPrint(n+2, node.left);
        return s;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree, p, q, r;
        p = new BinaryTreeNode("h", null, null);
        q = new BinaryTreeNode("i", null, null);
        p = new BinaryTreeNode("d", p, q);
        q = new BinaryTreeNode("j", null, null);
        q = new BinaryTreeNode("e", null, q);
        r = new BinaryTreeNode("b", p, q);

        p = new BinaryTreeNode("f", null, null);
        q = new BinaryTreeNode("k", null, null);
        q = new BinaryTreeNode("g", q, null);
        p = new BinaryTreeNode("c", p, q);

        tree = new BinaryTreeNode("a", r, p);

        System.out.println(tree);
        System.out.println(prettyPrint(tree));
    }
}
