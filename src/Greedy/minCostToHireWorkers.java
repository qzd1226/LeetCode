package Greedy;

import org.junit.jupiter.api.Test;
import java.util.*;
public class minCostToHireWorkers {
    @Test
    public void minCostTest(){
        int[] quality = {10,20,5};
        int[] wages = {70,50,30};
        int k = 2;
        double ans = mincostToHireWorkers(quality,wages,k);
        System.out.println(ans);
    }
    public class WorkerEfficiency{
        int id;
        double efficient;
        WorkerEfficiency(int id, double efficient){
            this.id = id;
            this.efficient = efficient;
        }
    }
            public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
                int n = quality.length;
                Integer[] h = new Integer[n];
                for (int i = 0; i < n; i++) {
                    h[i] = i;
                }
                Arrays.sort(h, (a, b) -> {
                    return quality[b] * wage[a] - quality[a] * wage[b];
                });
                double res = 1e9;
                double totalq = 0.0;
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
                for (int i = 0; i < k - 1; i++) {
                    totalq += quality[h[i]];
                    pq.offer(quality[h[i]]);
                }
                for (int i = k - 1; i < n; i++) {
                    int idx = h[i];
                    totalq += quality[idx];
                    pq.offer(quality[idx]);
                    double totalc = ((double) wage[idx] / quality[idx]) * totalq;
                    res = Math.min(res, totalc);
                    totalq -= pq.poll();
                }
                return res;
            }
            @Test
            public void test02(){
                    int count = 0;
                for(int i = 100; i < 1000; i++){
                    if(i % 10 == 9 && i % 9 == 8 && i % 8 == 7 ){
                        count ++;
                    }
                }
                System.out.println(count);
            }
        }


