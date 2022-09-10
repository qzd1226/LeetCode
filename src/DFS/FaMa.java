package DFS;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class FaMa {
    Set<Integer> set;
    int ans;
    @Test
    public void FaMaTest(){
        ans = 1; // 0直接加进去
        set = new HashSet<Integer>();
        int[] weight = {75};
        int[] nums = {5};
        dfs(0,nums,weight);
        System.out.println(ans);

    }
    public void dfs(int curSum, int[] nums, int[] weight){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                curSum = curSum + weight[i];
                if(!set.contains(curSum)){
                    set.add(curSum);
                   //System.out.println(curSum);
                    ans ++;
                }
                nums[i]--;
                dfs(curSum,nums,weight);
                nums[i]++;
                curSum = curSum - weight[i];
            }
        }
    }

}
