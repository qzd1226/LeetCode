package Dijkstra;
import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 10; i >= 0; i--){
            minHeap.offer(i);
        }
        minHeap.offer(-1);
        minHeap.offer(100);
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
        //PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
    }
}
