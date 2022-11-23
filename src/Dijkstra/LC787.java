package Dijkstra;
import java.util.*;
//787. Cheapest Flights Within K Stops
//        There are n cities connected by some number of flights.
//        You are given an array flights where flights[i] = [fromi, toi, pricei]
//        indicates that there is a flight from city fromi to city toi with cost pricei.
//        You are also given three integers src, dst, and k, return the cheapest price
//        from src to dst with at most k stops. If there is no such route, return -1.
public class LC787 {
    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int n = 3, src = 0, dst = 2, k = 0;
        int ans = findCheapestPrice(n,flights, src, dst, k);
        System.out.println("ans:" + ans);
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build the graph
        int mat[][] = new int[n][n];
        for (int flight[] : flights) {
            mat[flight[0]][flight[1]] = flight[2];
        }

        // min heap: {(vertex, cost, stops), ...}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);

        // costs[i]: min cost from src to vertex i
        // stops[i]: number of stops of the corresponding cheapest cost for vertex i
        int costs[] = new int[n];
        int stops[] = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        // Dijkstra Algorithm within k
        minHeap.offer(new int[] {src, 0, k});
        while (!minHeap.isEmpty()) {
            int elem[] = minHeap.poll();
            int vertex = elem[0], cost = elem[1], stop = elem[2];

            if (vertex == dst) {
                return cost;
            } else if (stop < 0) {
                continue;
            }

            for (int i = 0; i < n; ++i) {
                if (mat[vertex][i] > 0) {
                    int costI = costs[i], costVI = mat[vertex][i];
                    if (cost + costVI < costI) {
                        minHeap.offer(new int[] {i, costVI + cost, stop - 1});
                        costs[i] = costVI + cost;
                        stops[i] = stop - 1;
                    } else if (stops[i] < stop - 1) {
                        minHeap.offer(new int[] {i, costVI + cost, stop - 1});
                    }
                }
            }
        }
        return -1;
    }
}
