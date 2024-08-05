import java.util.Arrays;

public class Dijkstra2 {
    int nTown;
    double[][] map;
    double[] distance;
    int src;

    Dijkstra2(double[][] map) {
        this.map = map;
        nTown = map.length;
    }

    public void solve(int src, int dst) {
        this.src = src;
        boolean[] selected = new boolean[nTown];
        distance = new double[nTown];

        Arrays.fill(distance, Double.MAX_VALUE);
        Arrays.fill(selected, false);

        distance[src] = 0;

        while (true) {
            int marked = minIndex(distance, selected);

            if (marked < 0) return;
            if (distance[marked] == Double.MAX_VALUE) return;
            selected[marked] = true;
            if (marked == dst) return;

            for (int i = 0; i < nTown; i++) {
                if (map[marked][i] > 0 && !selected[i]) {
                    double newDistance = distance[marked] + map[marked][i];
                    
                    if (newDistance < distance[i]) distance[i] = newDistance;
                }
            }
        }
    }

    private int minIndex(double[] distance, boolean[] selected) {
        double dist = Double.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < nTown; i++) {
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
}
