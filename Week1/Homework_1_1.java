public class Homework_1_1 {

    /*
     * Homework 1.1:
     * Add codes to generate:
     * a) a random number in range 0, 1, 2, 3
     * b) a random number in range 1, 2, 3, 4, 5, 6
     * c) a random number in range 2, 4, 6, 8
     * d) a random number in range -5, -4, ..., 4, 5
     */

    public static void main(String[] args) {
        double d = Math.random();
        System.out.println((int) (d * 4) % 4);
        System.out.println((int) (d * 6) % 6 + 1);
        System.out.println((int) ((d * 4) % 4 + 1) * 2);
        System.out.println((int) (d * 11) % 11 - 5);
    }
}