public class TestRectangle {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(3.5, 5.25);
        a.x0 = 3;
        a.y0 = 4;

        a.printInfo();
        System.out.println("Area of Rectangle a = " + a.getArea() + "\n");

        Rectangle b = new Rectangle(4);
        b.x0 = 2;
        b.y0 = 5;

        b.printInfo();
        System.out.println("Area of Rectangle b = " + b.getArea() + "\n");

        Rectangle c = new Rectangle(3.14, 2.72);
        c.x0 = 6;
        c.y0 = -1;

        c.printInfo();
        System.out.println("Area of Rectangle c = " + c.getArea() + "\n");

        System.out.printf("Is Rectangle a larger than Rectangle b? %b%n", a.isLargerThan(b));
        System.out.printf("Is Rectangle c larger than Rectangle b? %b%n", c.isLargerThan(b));
        System.out.printf("Does Rectangle a intersect with Rectangle b? %b%n", a.isIntersectingWith(b));
        System.out.printf("Does Rectangle c intersect with Rectangle a? %b%n", c.isIntersectingWith(a));
    }
}
