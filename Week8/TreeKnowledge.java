import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeKnowledge {
    List<String> lines; // Store the lines connecting the nodes to it's child(s)
    Scanner sc;
    BinaryTreeNode root;
    int level; // Keep track of the max tree height
    int maxAnswerLength; // Store the longest answer on the highest tree level

    TreeKnowledge(Scanner sc) {
        this.sc = sc;
        root = new BinaryTreeNode("Komputer", null, null);
    }

    public boolean YorN(String s) {
        while (true) { // Check player input whether a statement is true or not
            System.out.print(s + " (y/n)? ");
            String ans = sc.nextLine();

            if (ans.startsWith("y"))
                return true;
            else if (ans.startsWith("n"))
                return false;
            else
                System.out.println("Please answer y or n.");
        }
    }

    public boolean printLevel(BinaryTreeNode t, int level, int width) {
        if (t == null) { // If null, print spaces with the length of width
            System.out.print(centerString(width, ""));
            return false;
        }

        // Create the line that connect the nodes to it's child(s)
        String line;
        int gap = width / 4;

        if (t.left != null && t.right != null) // If the node have 2 childs
            line = String.format("┌%s┴%s┐", "─".repeat(gap - 1), "─".repeat(gap - 1));
        else // If the node have no child
            line = "";

        // Add lines to list with its label to prevent any duplication during the
        // recursion
        String labeledLine = t.label + line;
        if (!lines.contains(labeledLine))
            lines.add(labeledLine);

        // print out the label at the center of the printable area
        if (level == 1) {
            System.out.print(centerString(width, t.label));
            return true;
        }

        // Call the next level
        boolean left = printLevel(t.left, level - 1, width / 2);
        boolean right = printLevel(t.right, level - 1, width / 2);
        return left || right;
    }

    public void prettyPrint(BinaryTreeNode t, int level, int maxLetterWidth) { // print tree vertically, cause why not?
        int startLevel = 1; // Starting tree level
        int startIdx = 0;
        int maxLength = (int) Math.pow(2, level) * (maxLetterWidth * 3 / 4);
        int width = maxLength; // Max width needed to print the tree without any of it's component hitting one
                               // another

        lines = new ArrayList<>(); // List to store the line(s)
        while (printLevel(t, startLevel, maxLength)) {
            System.out.println();

            while (startIdx < lines.size()) {
                String s = lines.get(startIdx++).replaceAll("[\\w\\p{Punct} ]", ""); // Remove any alphanumeric letter
                System.out.print(centerString(width, s)); // Print the lines
            }

            // Halved the width for the next level
            width = maxLength / (int) Math.pow(2, startLevel++);
            System.out.println();
        }
    }

    public String centerString(int width, String s) {
        int padding = Math.max(0, width - s.length()); // Make sure that the string is always at the middle
        int leftPadding = padding / 2;
        int rightPadding = padding - leftPadding;

        return String.format("%s%s%s", " ".repeat(leftPadding), s, " ".repeat(rightPadding));
    }

    public void run() {
        while (true) {
            int treeLevel = 1; // Keep track of the current tree level when running the knowledge tree
            BinaryTreeNode x = root;
            System.out.println("Pikirkan sebuah benda!");
            while (true) {
                if (x.left == null && x.right == null) {
                    String isWord = "Apakah benda tersebut " + x.label;
                    if (YorN(isWord))
                        break;
                    else {
                        System.out.println("Beritahu Jawabannya!");
                        String answer = sc.nextLine();
                        System.out.printf("Masukkan pertanyaan yang jika dijawab YES adalah %s dan jika dijawab NO adalah %s%n",
                                answer, x.label);
                        String question = sc.nextLine();

                        // Update the tree
                        x.left = new BinaryTreeNode(answer, null, null);
                        x.right = new BinaryTreeNode(x.label, null, null);
                        x.label = question;
                        treeLevel++; // Increment the level as you expand the tree

                        level = Math.max(level, treeLevel); // Compare the last accessed tree level with the max level
                                                            // ever accessed
                        if (treeLevel == level) // Update the maxAnswerLength if the current accessed level matched with
                                                // the max level
                            maxAnswerLength = Math.max(x.right.label.length(), answer.length());
                    }
                    break;
                }
                x = (YorN(x.label)) ? x.left : x.right;
                treeLevel++; // Increment the treeLevel
            }
            if (!YorN("Lanjut")) {
                System.out.println();
                prettyPrint(root, level, maxAnswerLength); // Print the tree
                break;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeKnowledge tk = new TreeKnowledge(new Scanner(System.in));
        tk.run();
    }
}
