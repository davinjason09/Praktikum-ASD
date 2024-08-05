import java.util.*;
import java.util.Queue;

public class PrintTree {
    public static String[] toArray(BinaryTreeNode t) {
        List<String> result = new ArrayList<String>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(t);
        while (!q.isEmpty()) {
            BinaryTreeNode x = q.remove();
            if (x == null) result.add(null);
            else {
                result.add(x.label);
                q.add(x.left);
                q.add(x.right);
            }
        }

        String[] s = result.toArray(String[]::new);
        return s;
    }
    
    public static void print(String[] array) {
        int size = array.length;
        int level = log2(size);
        int maxLetterWidth = (int) Math.ceil(getMaxLetterWidth(array, size) * 0.75);
        int maxLength = (int) Math.pow(2, level) * maxLetterWidth;
        int currentLevel = -1 ;
        int width = maxLength;

        int x = -1;
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (log2(i + 1) > currentLevel) {
                currentLevel++;
                x += (int)(Math.pow(2, currentLevel));
                System.out.println();
                width = maxLength / (int) Math.pow(2, currentLevel);
            }
            String s = String.valueOf(array[i]);
            System.out.print(centerString(width, (s != "null") ? s : " "));

            if (i == x) {
                System.out.println();
                while (j <= i && currentLevel < level - 1) {
                    String line = "";
                    if (array[2*j + 1] != null && array[2*j + 2] != null) {
                        line += "┌" + "─".repeat(width/4-1) + "┴" + "─".repeat(width/4-1) + "┐";
                    }
                    else if (array[2*j + 1] != null) {
                        line += "┌" + "─".repeat(width/4-1) + "┘" + " ".repeat(width/4);
                    }
                    else if (array[2*j + 2] != null) {
                        line += " ".repeat(width/4) + "└" + "─".repeat(width/4-1) + "┐";
                    }
                    System.out.print(centerString(width, line));
                    j++;
                }
            }
        }   
    }
    
    private static String centerString(int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    private static int log2(int n) {
        return (int)(Math.log(n) / Math.log(2));
    }

    private static int getMaxLetterWidth(String[] array, int size) {
        int start = (int)Math.pow(2, log2(size)-1);
        int max = Integer.MIN_VALUE;
        for (int i = start - 1; i < size; i++) {
            if (array[i] != null) max = Math.max(array[i].length(), max);
        }
        return max;
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

        String[] array = toArray(tree);
        print(array);
    }
}
