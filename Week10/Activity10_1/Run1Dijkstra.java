import java.util.Scanner;

public class Run1Dijkstra {
    static double[][] map;
    static int src;
    static int dst;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah node : ");
        int nTown = sc.nextInt();
        map = new double[nTown][nTown];

        for (int i = 0; i < nTown; i++) {
            for (int j = i+1; j < nTown; j++) {
                System.out.printf("Masukkan weight antara node %d dan %d = ", i, j);
                map[i][j] = map[j][i] = sc.nextDouble();
            }
        }
        System.out.println();

        System.out.print("Masukkan starting node = ");
        src = sc.nextInt();
        System.out.print("Masukkan destination node = ");
        dst = sc.nextInt();

        Dijkstra1 dj = new Dijkstra1(map);
        dj.solve(src, dst);
        System.out.println("Jarak yang harus ditempuh = " + dj.getDistance(dst));

        sc.close();
    }
}
