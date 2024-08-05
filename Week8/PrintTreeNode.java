import java.util.*;

public class PrintTreeNode {
    static List<List<String>> lines;

    public static boolean printLevel(BinaryTreeNode t, int level, int width) {
        if (t == null) {
            System.out.print(centerString(width, ""));
            return false;
        }
        
        String line;
        int gap = width/4;
        
        if (t.left != null && t.right != null) {
            line = String.format("┌%s┴%s┐", "─".repeat(gap-1), "─".repeat(gap-1));
        } else if (t.left != null) {
            line = String.format("┌%s┘%s", "─".repeat(gap-1), " ".repeat(gap));
        } else if (t.right != null) {
            line = String.format("%s└%s┐", " ".repeat(gap), "─".repeat(gap-1));
        } else {
            line = "";
        }
        
        List<String> labeledLine = new ArrayList<>();
        labeledLine.add(t.label);
        labeledLine.add(line);
        if (!lines.contains(labeledLine)) lines.add(labeledLine);
        
        if (level == 1) {
            System.out.print(centerString(width, t.label));
            return true;
        }
        
        boolean left = printLevel(t.left, level - 1, width / 2);
        boolean right = printLevel(t.right, level - 1, width / 2);
        return left || right;
    }
    
    public static void print(BinaryTreeNode t, int level, int maxLetterWidth) {
        int startLevel = 1;
        int startidx = 0;
        int maxLength = (int) Math.pow(2, level) * (int) Math.ceil(maxLetterWidth * 0.75);
        int width = maxLength;

        lines = new ArrayList<>();
        while (printLevel(t, startLevel, maxLength)) {
            System.out.print(width);
            System.out.println();

            while (startidx < lines.size()) {
                String s = lines.get(startidx++).get(1);
                System.out.print(centerString(width, s));
            }
            width = maxLength / (int) Math.pow(2, startLevel++);
            System.out.println();
        }
    }

    public static String centerString(int width, String s) {
        int padding = Math.max(0, width - s.length());
        int leftPadding = padding / 2;
        int rightPadding = padding - leftPadding;

        return String.format("%s%s%s", " ".repeat(leftPadding), s, " ".repeat(rightPadding));
    }  

    public static void main(String[] args) {
        BinaryTreeNode tree, p, q, r;
        p = new BinaryTreeNode("daun", null, null);
        q = new BinaryTreeNode("rumput", null, null);
        p = new BinaryTreeNode("ada di pohon?", p, q);
        q = new BinaryTreeNode("jeruk", null, null);
        q = new BinaryTreeNode("apakah kuning?", null, q);
        r = new BinaryTreeNode("apakah hijau?", p, q);

        p = new BinaryTreeNode("manusia", null, null);
        q = new BinaryTreeNode("komputer", null, null);
        q = new BinaryTreeNode("perlu listrik?", q, null);
        p = new BinaryTreeNode("apakah bergerak?", p, q);

        tree = new BinaryTreeNode("apakah merah?", r, p);

        int level = 4;
        int maxLetterWidth = 8;
        print(tree, level, maxLetterWidth);
    }
}
