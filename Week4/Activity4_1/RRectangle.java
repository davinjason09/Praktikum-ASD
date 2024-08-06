public class RRectangle {
    double width;
    double height;

    public void getArea() {
        System.out.println("Area : " + this.width * this.height);
    }

    public boolean isLargerThan(RRectangle b) {
        return (this.width * this.height) > (b.width * b.height);
    }

    RRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}
