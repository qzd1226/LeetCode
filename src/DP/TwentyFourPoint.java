package DP;

import org.junit.jupiter.api.Test;
import java.util.*;
public class TwentyFourPoint {
    boolean ans;
    @Test
    public void testTwentyFourPoint(){
        ans = false;
        double[] arr = {9,6,4,1};
        dfs(arr,0.0, 1, new boolean[4]);
        System.out.println(ans);
    }
    public void dfs(double[] arr, double sum, int curLocation, boolean[] visited){
        if(curLocation == 4){
            int next = -1;
            for(int i = 0; i < visited.length; i++){
                if(visited[i] == false){
                    next = i;
                }
            }
            visited[next] = true;
            double curNum = arr[next];
            if(sum + curNum == 24){
                ans = true;
            }else if(sum - curNum == 24){
                ans = true;
            }else if(sum / curNum == 24){
                ans = true;
            }else if(sum * curNum == 24){
                ans = true;
            }
            visited[next] = false;
            return;
        }else if (curLocation == 1){
            for(int i = 0; i < visited.length; i++){
                visited[i] = true;
                curLocation ++;
                dfs(arr,arr[i], curLocation,visited);
                dfs(arr,-arr[i],curLocation,visited);
                dfs(arr,1/arr[i],curLocation,visited);
                visited[i] = false;
            }
        }else if(curLocation > 4){
            return;
        } else{
            for(int i = 0; i < visited.length; i++){
                if(visited[i] == false){
                    visited[i] = true;
                    curLocation ++;
                    dfs(arr, sum + arr[i],curLocation,visited);
                    dfs(arr, sum - arr[i], curLocation, visited);
                    dfs(arr, sum / arr[i], curLocation, visited);
                    dfs(arr, sum * arr[i],curLocation,visited);
                    visited[i] = false;
                }
            }
        }
    }
}

