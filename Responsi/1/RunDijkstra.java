// Davin Jason Evan Raharjo
// 22/493367/PA/21184

import java.util.*;

public class RunDijkstra {
	static double[][] map;
	static int src;
	static int dst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Masukkan jumlah node = ");
		int nTown = sc.nextInt(); //jumlah node
		map = new double[nTown][nTown];
		
		//inisialisasi nilai elemen adjacency matrix untuk graf pada soal
		//cukup menginputkan matrix segitiga atas saja (tanpa diagonal) dari keyboard
		System.out.println("Masukkan adjacency matrix :");
		for(int i = 0; i < nTown; i++) {
			for(int j = i+1; j < nTown; j++) map[i][j] = map[j][i] = sc.nextDouble();
		}
						
		System.out.print("Masukkan starting node = ");
		src = sc.nextInt();
		System.out.print("Masukkan destination node = ");
		dst = sc.nextInt();
		
		Dijkstra dj = new Dijkstra(map);
		dj.solve(src,dst); //hitung jarak terpendek
		System.out.println("Jarak Terpendek = " + dj.getDistance(dst)); //print nilai jarak terpendek
		System.out.println("Array Parent    = " + Arrays.toString(dj.getParentArray())); //print array parent
		System.out.print("Rute terpendek  = ");
		dj.printRouteTo(dst); //print rute ke destination node

		sc.close();
	}
}