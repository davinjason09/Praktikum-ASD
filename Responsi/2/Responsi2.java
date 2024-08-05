// Davin Jason Evan Raharjo
// 22/493367/PA/21184

import java.util.*;

public class Responsi2 {
    static double[][] map;
	static int src;
	static int dst;
    static int[] location;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Masukkan jumlah router = ");
		int nRouter = sc.nextInt(); //jumlah node
		map = new double[nRouter][nRouter];
		
		//inisialisasi nilai elemen adjacency matrix untuk graf pada soal
		//cukup menginputkan matrix segitiga atas saja (tanpa diagonal) dari keyboard
		System.out.println("Masukkan adjacency matrix :");
		for (int i = 0; i < nRouter; i++) {
			for (int j = i+1; j < nRouter; j++) map[i][j] = map[j][i] = sc.nextDouble();
		}
		
        System.out.print("\nMasukkan jumlah device = ");
        int nDevice = sc.nextInt(); //jumlah device
        location = new int[nDevice];

        //masukkan lokasi device
        for (int i = 0; i < nDevice; i++) {
            System.out.printf("Masukkan lokasi device %d = ", i+1);
            location[i] = sc.nextInt();
        }

		Network dj = new Network(map);

        for (int i = 0; i < nDevice; i++) {
            for (int j = i+1; j < nDevice; j++) {
                int start = location[i];
                int end = location[j];
                System.out.printf("%nDevice %d ke %d%n", i+1, j+1);
                dj.solve(start, end); //hitung jarak terpendek
                dj.countVisitedNode(end);
                System.out.println("Jarak Terpendek = " + dj.getDistance(end)); //print nilai jarak terpendek
                System.out.println("Array Parent    = " + Arrays.toString(dj.getParentArray())); //print array parent
                System.out.print("Rute terpendek  = ");
                dj.printRouteTo(end); //print rute ke destination node
            }
        }

        int mostVisited = dj.mostVisitedNode();
        System.out.println("\nRouter yang paling sering dilalui = Router " + mostVisited);
        //buat node yang terhubung dengan node di atas inf
        dj.updateMap(mostVisited);

        System.out.printf("%nJika router %d rusak, maka :%n", mostVisited);
        System.out.print("Masukkan starting node = ");
		src = sc.nextInt();
		System.out.print("Masukkan destination node = ");
		dst = sc.nextInt();
		dj.solve(src,dst); //hitung jarak terpendek
		System.out.println("Jarak Terpendek = " + dj.getDistance(dst)); //print nilai jarak terpendek
		System.out.println("Array Parent    = " + Arrays.toString(dj.getParentArray())); //print array parent
		System.out.print("Rute terpendek  = ");
		dj.printRouteTo(dst); //print rute ke destination node

		sc.close();
	}
}
