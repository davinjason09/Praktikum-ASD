public class TestCube {
    public static void main(String[] args) {
        Cube a = new Cube(3.58, 5.08, 3.59);
        a.x0 = 1;
        a.y0 = 4;
        a.z0 = 2;

        a.printInfo();
        System.out.println("Surface area of Cube a = " + a.getArea());
        System.out.println("Volume of Cube a = " + a.getVolume() + "\n");

        Cube b = new Cube(4.76);
        b.x0 = 3;
        b.y0 = 0;
        b.z0 = -1;

        b.printInfo();
        System.out.println("Surface area of Cube b = " + b.getArea());
        System.out.println("Volume of Cube b = " + b.getVolume() + "\n");

        Cube c = new Cube(3.97, 4.42, 2.48);
        c.x0 = -2;
        c.y0 = 5;
        c.z0 = -3;

        c.printInfo();
        System.out.println("Surface area of Cube c = " + c.getArea());
        System.out.println("Volume of Cube c = " + c.getVolume() + "\n");

        System.out.printf("Is Cube b larger than Cube a? %b%n", b.isLargerThan(a));
        System.out.printf("Is Cube c larger than Cube b? %b%n", c.isLargerThan(b));
        System.out.printf("Does Cube a intersect with Cube b? %b%n", a.isIntersectingWith(b));
        System.out.printf("Does Cube c intersect with Cube a? %b%n", c.isIntersectingWith(a));
    }
}
