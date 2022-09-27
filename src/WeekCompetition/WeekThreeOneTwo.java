package WeekCompetition;
import java.util.*;
public class WeekThreeOneTwo {
    static boolean res;
    public static void main(String[] args) {
        int[] vals = {1,3,2,1,3};
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
        int ans = numberOfGoodPaths(vals,edges);
        System.out.println(ans);
    }
    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        if(vals.length == 1){
            return 1;
        }
        int ans = vals.length;
        // build the link map
        Map<Integer, List> linkMap= new HashMap<Integer,List>();
        for(int i = 0; i < edges.length; i++){
            List<Integer> temp = linkMap.getOrDefault(edges[i][0],new LinkedList<Integer>());
            temp.add(edges[i][1]);
            linkMap.put(edges[i][0],temp);
            temp = linkMap.getOrDefault(edges[i][1],new LinkedList<Integer>());
            temp.add(edges[i][0]);
            linkMap.put(edges[i][1],temp);
        }

        // build the value map and the valueset
        // the key is the val
        // the value is node
        Map<Integer, List> valueMap = new HashMap<Integer,List>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < vals.length; i++){
            if(!set.contains(vals[i])){
                set.add(vals[i]);
            }
            List<Integer> temp = valueMap.getOrDefault(vals[i], new LinkedList<Integer>());
            temp.add(i);
            valueMap.put(vals[i],temp);
        }
        // find the value that have multi nodes
        for(int val:set){
            List<Integer> tempList = valueMap.get(val);
            int size = tempList.size();
            if(size > 1){
                for(int a = 0; a < tempList.size() - 1; a ++){
                    for(int b = 1; b < tempList.size(); b++){
                        res = false;
                        connected(linkMap, vals, tempList.get(a), tempList.get(b), vals[tempList.get(a)], new boolean[vals.length]);
                        if(res == true){
                            ans ++;
                        }

                    }
                }
            }
        }
        return ans;
    }

    public static void connected(Map<Integer,List> linkMap, int[] vals, int begin, int target, int beginVal, boolean[] visited){
        if(res == true){
            return;
        }
        List toNode = linkMap.getOrDefault(begin,new LinkedList());
        if(toNode.size() == 0){
            return;
        }
        for(int i = 0; i < toNode.size(); i++){
            int nextNode = (int)toNode.get(i);
            if(nextNode == target){
                res = true;
                return;
            }
            if(vals[nextNode] > beginVal){
                continue;
            }else{
                if(visited[nextNode] == true){
                    continue;
                }else {
                    visited[nextNode] = true;
                    connected(linkMap, vals, nextNode,target,beginVal, visited);
                    visited[nextNode] = false;
                }
            }
        }
        return;
    }


}
