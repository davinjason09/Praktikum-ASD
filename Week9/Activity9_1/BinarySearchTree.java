import java.util.*;

public class BinarySearchTree {
    private List<List<String>> lines;
    private int level;
    private int maxLetterWidth;
    private BinarySearchNode root;

    //Constructor
    BinarySearchTree() {
        root = null;
    }

    // Method to insert a data
    public void insert(Integer data) {
        BinarySearchNode p = root;
        BinarySearchNode parent = null;

        boolean isLeftChild = false;
        while (p != null) {
            int result = data.compareTo(p.data);
            if (result == 0) {
                System.out.println(data + "already exist");
                return;
            } else if (result < 0) {
                parent = p;
                isLeftChild = true;
                p = p.left;
            } else {
                parent = p;
                isLeftChild = false;
                p = p.right;
            }
        }

        // Create a new node under parent
        // Determine whether it is left or right child based on isLeftChild
        BinarySearchNode newNode = new BinarySearchNode(data);
        if (parent == null) {
            root = newNode;
        } else if (isLeftChild) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        //Update tree level & maxWidthLength
        level = getTreeLevel(root);
        maxLetterWidth = Math.max(maxLetterWidth, data.toString().length());
    }

    // Method to search a data
    public void search(Integer data) {
        BinarySearchNode p = root;
        while (p != null) {
            int result = data.compareTo(p.data);
            if (result == 0) {
                System.out.println(data + " found");
                return;
            } else if (result < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        System.out.println(data + " is not found");
    }

    // Method to delete a data
    public void delete(Integer data) {
        BinarySearchNode p = root;
        BinarySearchNode parent = null;

        boolean isLeftChild = false;
        while (p != null) {
            int result = data.compareTo(p.data); // data == p.data
            if (result == 0) { // data is found
                if (p.left == null && p.right == null) {  // p is an external node
                    if (parent == null) root = null;
                    else if (isLeftChild) parent.left = null;
                    else parent.right = null;
                } else if (p.left == null) { // p only has right subtree
                    if (parent == null) root = p.right;
                    else if (isLeftChild) parent.left = p.right;
                    else parent.right = p.right;
                } else if (p.right == null) { // p only has left subtree
                    if (parent == null) root = p.left;
                    else if (isLeftChild) parent.left = p.left;
                    else parent.right = p.left;
                } else {
                    BinarySearchNode x = findMin(p); // Find the smallest node from the right subtree

                    //Replace p with x
                    if (parent == null) root = x;
                    else if (isLeftChild) parent.left = x;
                    else parent.right = x;
                    x.right = p.right;
                    x.left = p.left;
                    p.right = null;
                    p.left = null;
                }

                //Update tree level
                level = getTreeLevel(root);

                System.out.println(data + " has been deleted");
                return;
            } else if (result < 0) {
                parent = p;
                isLeftChild = true;
                p = p.left;
            } else {
                parent = p;
                isLeftChild = false;
                p = p.right;
            }
        }
        System.out.println(data + " is not found");
    }

    // Method to find the smallest node of a right subtree
    private BinarySearchNode findMin(BinarySearchNode parent) {
        BinarySearchNode p = parent.right;
        
        while (p.left != null) {
            p = p.left;
        }

        return p;
    }

    public String toString() {
        return inorder(root);
    }

    private String inorder(BinarySearchNode p) {
        if (p == null) return "";
        return inorder(p.left) + p.data + " " +inorder(p.right);
    }

    private boolean printLevel(BinarySearchNode t, int currentLevel, int width) {
        if (t == null) { // If null, print spaces with the length of width
            System.out.print(centerString(width, ""));
            return false;
        }
        
        // Create the line that connect the nodes to it's child(s)
        String line;
        int gap = width/4;
        
        if (t.left != null && t.right != null) // If the node have 2 childs
            line = String.format("┌%s┴%s┐", "─".repeat(gap-1), "─".repeat(gap-1));
        else if (t.left != null) 
            line = String.format("┌%s┘%s", "─".repeat(gap-1), " ".repeat(gap));
        else if (t.right != null) 
            line = String.format("%s└%s┐", " ".repeat(gap), "─".repeat(gap-1));
        else // If the node have no child
            line = "";

        // Add lines to list with its label to prevent any duplication during the recursion
        List<String> labeledLine = new ArrayList<>();
        labeledLine.add(t.data.toString());
        labeledLine.add(line);
        if (!lines.contains(labeledLine)) lines.add(labeledLine);
        
        //print out the label at the center of the printable area
        if (currentLevel == 1) {
            System.out.print(centerString(width, t.data.toString()));
            return true;
        }
        
        // Call the next level
        boolean left = printLevel(t.left, currentLevel - 1, width / 2);
        boolean right = printLevel(t.right, currentLevel - 1, width / 2);
        return left || right;
    }
    
    public void prettyPrint(BinarySearchNode t, int level, int maxLetterWidth) { //print tree vertically, cause why not?
        int startLevel = 1; // Starting tree level
        int startIdx = 0;
        int maxLength = (int) Math.pow(2, level) * (int) Math.ceil(maxLetterWidth * 0.75);
        int width = maxLength; // Max width needed to print the tree without any of it's component hitting one another
    
        lines = new ArrayList<>(); // List to store the line(s)
        System.out.println("Tree :");
        while (printLevel(t, startLevel, maxLength)) {
            System.out.println();
    
            while (startIdx < lines.size()) {
                String s = lines.get(startIdx++).get(1);
                System.out.print(centerString(width, s)); // Print the lines
            }
            
            // Halved the width for the next level
            width = maxLength / (int) Math.pow(2, startLevel++);
            System.out.println();
        }
        System.out.print("\n\033[F");
    }
    
    private String centerString(int width, String s) {
        int padding = Math.max(0, width - s.length()); // Make sure that the string is always at the middle
        int leftPadding = padding / 2;
        int rightPadding = padding - leftPadding;

        return String.format("%s%s%s", " ".repeat(leftPadding), s, " ".repeat(rightPadding)); 
    } 

    private int getTreeLevel(BinarySearchNode root) {
        if (root == null) {
            return 0; // An empty tree has level 0
        } else {
            int leftLevel = getTreeLevel(root.left);
            int rightLevel = getTreeLevel(root.right);
    
            // Return the maximum of the left and right subtree levels, plus 1 for the current node
            return Math.max(leftLevel, rightLevel) + 1;
        }
    }

    public int getLevel() {
        return level;
    }

    public int getMaxWordLength() {
        return maxLetterWidth;
    }

    public BinarySearchNode getRoot() {
        return root;
    }
}
