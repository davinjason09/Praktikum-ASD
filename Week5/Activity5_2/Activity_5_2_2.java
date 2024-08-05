public class Activity_5_2_2 {
    static class X {
        X() {
            System.out.println("[X()]");
        }

        X(int i) {
            System.out.println("[X(int i)]");
        }
    }

    static class Y extends X {
        Y() {
            System.out.println("[Y()]");
        }

        Y(int i) {
            System.out.println("[Y(int i)]");
        }
    }

    static class Z extends Y {}

    public static void main(String[] args) {
        // Y y0 = new Y();
        // Y y1 = new Y(10);
        // Z z = new Z();
    }
}
