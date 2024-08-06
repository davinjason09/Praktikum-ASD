import java.util.Stack;

public class Reverse_n_Palindrome {
    public static String reverse(String s) {
        String reverse = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
            stack.push(s.charAt(i));

        while (!stack.isEmpty())
            reverse += stack.pop();

        return reverse;
    }

    public static boolean isPalindrome(String s) {
        String reverse = reverse(s);
        return s == reverse;
    }

    public static void main(String[] args) {
        String s1 = "REVELATION";
        String s2 = "TACOCAT";

        System.out.printf("Original String = %s%nReversed String = %s%n", s1, reverse(s1));
        System.out.printf("Original String = %s%nReversed String = %s%n", s2, reverse(s2));

        System.out.printf("%s is %sa palindrome%n", s1, isPalindrome(s1) ? "" : "not ");
        System.out.printf("%s is %sa palindrome%n", s2, isPalindrome(s2) ? "" : "not ");
    }
}
