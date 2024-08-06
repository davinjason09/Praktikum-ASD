public class Cube extends Rectangle {
    double depth;
    double z0;

    Cube(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }

    Cube(double size) {
        super(size);
        depth = size;
    }

    public void printInfo() {
        System.out.println("Depth  = " + depth);
        super.printInfo();
    }

    public double getArea() {
        return 2 * (super.getArea() + width * depth + height * depth);
    }

    public double getVolume() {
        return super.getArea() * depth;
    }

    public boolean isLargerThan(Cube c) {
        return this.getVolume() > c.getVolume();
    }

    public boolean isIntersectingWith(Cube c) {
        boolean overlapZ = (this.z0 + this.depth >= c.z0) && (c.z0 + c.depth >= this.z0);

        return super.isIntersectingWith(c) && overlapZ;
    }
}
