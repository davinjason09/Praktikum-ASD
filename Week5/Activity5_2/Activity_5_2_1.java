public class Activity_5_2_1 {
    static class X {
        X() {
            System.out.println("[X]");
        }

        public void a() {
            System.out.println("[x.a]");
        }

        public void b() {
            System.out.println("[x.b]");
        }
    }

    static class Y extends X {
        Y() {
            System.out.println("[Y]");
        }

        public void a() {
            System.out.println("[y.a]");
        }
    }
    
    public static void main(String[] args) {
        X x = new X();
        x.a();
        x.b();

        Y y = new Y();
        y.a();
        y.b();
    }
}