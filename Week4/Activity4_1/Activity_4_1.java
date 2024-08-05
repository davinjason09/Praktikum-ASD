public class Activity_4_1 {
    public static void main(String[] args) {
        RRectangle a = new RRectangle(1.7, 0.9);
        a.getArea();
        RRectangle b = new RRectangle(2.3, 0.625);
        b.getArea();

        System.out.printf("Is a greater than b? %b%n", a.isLargerThan(b));
    }
}
