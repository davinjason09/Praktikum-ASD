public class Rectangle {
    double width;
    double height;
    double x0;
    double y0;

    Rectangle(double width, double length) {
        this.width = width;
        height = length;
    }

    Rectangle(double size) {
        width = height = size;
    }

    public void printInfo() {
        System.out.println("Width  = " + width + "\nLength = " + height);
        System.out.println("Bottom-left coordinate = (" + x0 + ", " + y0 + ")");
    }

    public double getArea() {
        return width * height;
    }

    public boolean isLargerThan(Rectangle r) {
        return this.getArea() > r.getArea();
    }

    public boolean isIntersectingWith(Rectangle r) {
        boolean overlapX = (this.x0 + this.width >= r.x0) && (r.x0 + r.width >= this.x0);
        boolean overlapY = (this.y0 + this.height >= r.y0) && (r.y0 + r.height >= this.y0);

        return overlapX && overlapY;
    }
}
