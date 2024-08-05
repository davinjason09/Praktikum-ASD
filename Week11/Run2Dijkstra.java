import java.util.*;

public class Run2Dijkstra {
    static double[][] map;
    static int src;
    static int dst;

    public static void main(String[] args) {
        doInput();
        Dijkstra2 dj = new Dijkstra2(map);
        dj.solve(src, dst);
        System.out.println(dj.getDistance(dst));
    }

    static void doInput() {
        Scanner sc = new Scanner(System.in);
        int nTown = sc.nextInt();
        int nRoute = sc.nextInt();
        map = new double[nTown][nTown];

        for (int i = 0; i < nRoute; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            double len = sc.nextDouble();
            map[from][to] = map[to][from] = len;
        }

        src = sc.nextInt();
        dst = sc.nextInt();
        sc.close();
    }
}
