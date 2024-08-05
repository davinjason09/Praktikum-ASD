public class Homework_1_2 {

    /*
     * Homework 1.2:
     * Make a 9x9 multiplication table
     */

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d x %d = %d\t", i, j, i * j);
            }

            System.out.println(" ");
        }
    }
}