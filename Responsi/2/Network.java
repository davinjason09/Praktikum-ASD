// Davin Jason Evan Raharjo
// 22/493367/PA/21184

public class Network {
    int nRouter;
	double[][] map;
	double[] distance;
	int src;
	//(1) deklarasikan array bernama parent
    int[] parent;
    int[] counter;
	
	Network(double[][] map) {
		this.map = map;
		nRouter = map.length; //jumlah node (town)
        counter = new int[nRouter];
	}
	
	public void solve(int src, int dst) {
		this.src = src;
		boolean[] selected = new boolean[nRouter];
		distance = new double[nRouter];
        parent = new int[nRouter];

        for (int i = 0 ; i < nRouter; i++) {
			parent[i] = -1;
			counter[i] = 0;
			distance[i] = Double.MAX_VALUE;
		}

		distance[src] = 0;
		
		while (true) {
			int marked = minIndex(distance, selected);
						
			if (marked < 0) return; 
			if (distance[marked] == Double.MAX_VALUE) return; 
			selected[marked] = true;
			if (marked == dst) return;
					
			for (int j = 0; j < nRouter; j++) { 
				if (map[marked][j] > 0 && !selected[j]) { 
					double newDistance = distance[marked] + map[marked][j];
					if (newDistance < distance[j]) {
                        distance[j] = newDistance;
						parent[j] = marked;
                    }
				}
			}
		}
	}

	private int minIndex(double[] distance, boolean[] selected) {
		double dist = Double.MAX_VALUE; 
		int idx = -1; 
		
		for (int i = 0; i < nRouter; i++) {
			if (!selected[i] && distance[i] < dist) {
				dist = distance[i];
				idx = i;
			}
		}
		return idx;
	}
	
	public double getDistance(int dst) {
		return distance[dst];
	}

	public int[] getParentArray() {
		return parent;
	}
	
	public void printRouteTo(int dst) {
		int current = dst;
		String route = "";
		while (current != src) {
			route = " -> " + current + route;
			current = parent[current];
		}
		route = src + route;
		System.out.println(route);
	}

    public int mostVisitedNode() {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nRouter; i++) {
            if (counter[i] > max) {
                max = counter[i];
                idx = i;
            }
        }
        return idx;
    }

    public void countVisitedNode(int dst) {
        int current = dst;
		while (current != src) {
            counter[current]++;
            current = parent[current];
        }
    }

	public void updateMap(int node) {
		for (int i = 0; i < nRouter; i++) this.map[i][node] = this.map[node][i] = 0;
	}
}
