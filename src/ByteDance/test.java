package ByteDance;
import java.util.*;
public class test {
    public static void main(String[] args) {
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        long ans = totalCost(costs,k,candidates);
        //System.out.println(ans);
    }
    public static long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        for(int i = 0; i < k; i++){
            int remain = costs.length - i;
            if(remain >= candidates * 2){
                int[][] thisTurn = new int[candidates * 2][2];
                int headNum = 0;
                while(headNum < candidates){
                    for(int j = 0; j < costs.length; j++){
                        if(costs[j] != -1){
                            thisTurn[headNum][0] = costs[j];
                            thisTurn[headNum][1] = j;
                            headNum ++;
                        }
                    }
                }
                int tailNum = 0;
                while(tailNum < candidates){
                    for(int j = costs.length - 1; j >= 0; j--){
                        if(costs[j] != -1){
                            thisTurn[candidates+tailNum][0] = costs[j];
                            thisTurn[candidates+tailNum][1] = j;
                            tailNum ++;
                        }
                    }
                }
                Arrays.sort(thisTurn, (a,b) ->(a[0] - b[0]));
                int[] min = thisTurn[0];
                ans = ans + min[0];
                costs[min[1]] = -1;
            }else{
                int last = k - i;
                int[] cur = new int[costs.length];
                for(int j = 0; j < costs.length; j++){
                    cur[j] = costs[j];
                }
                Arrays.sort(cur);
                while(last > 0){
                    for(int j = 0; j < cur.length; j++){
                        if(cur[j] != -1){
                            ans = ans + cur[j];
                            last --;
                            i++;
                        }
                    }
                }
                return ans;
            }
        }
        return ans;
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        for(int i = 0; i < k; i++){
            int remain = costs.length - i;
            if(remain > candidates * 2){
                int[][] thisTurn = new int[candidates * 2][2];
                int headNum = 0;
                for(int j = 0; j < costs.length; j++){
                    if(costs[j] != -1){
                        thisTurn[headNum][0] = costs[j];
                        thisTurn[headNum][1] = j;
                        headNum ++;
                        if(headNum == candidates){
                            break;
                        }
                    }
                }
                //System.out.println("here!!");
                int tailNum = 0;
                for(int j = costs.length - 1; j >= 0; j--){
                    if(costs[j] != -1){
                        thisTurn[candidates+tailNum][0] = costs[j];
                        thisTurn[candidates+tailNum][1] = j;
                        tailNum ++;
                        if(tailNum == candidates){
                            break;
                        }
                    }
                }
                Arrays.sort(thisTurn, (a,b) ->(a[0] - b[0]));
                int[] min = thisTurn[0];
                //System.out.println("min:" + min[0]);
                ans = ans + min[0];
                costs[min[1]] = -1;
            }else{
                //System.out.println("here!!");
                int last = k - i;
                //System.out.println("remain:" + last);
                int[] cur = new int[costs.length];
                for(int j = 0; j < costs.length; j++){
                    cur[j] = costs[j];
                }
                Arrays.sort(cur);
                for(int j = 0; j < cur.length; j++){
                    if(cur[j] != -1){
                        //System.out.println("min j:" + cur[j]);
                        ans = ans + cur[j];
                        last --;
                        if(last == 0){
                            return ans;
                        }
                        i++;
                    }
                }
                return ans;
            }
        }
        return ans;
    }
}