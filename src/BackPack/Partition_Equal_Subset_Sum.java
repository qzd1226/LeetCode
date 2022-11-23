package BackPack;
import java.util.*;
public class Partition_Equal_Subset_Sum {
    public static void main(String[] args) {
        System.out.println(('A' - 'a'));
        int[] test = {2,2,1,1};
        boolean ans = canPartition(test);
        System.out.println(ans);
    }
    public static boolean canPartition(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            max = Math.max(max,nums[i]);
        }
        if(sum % 2 == 1){
            return false;
        }
        if(max >= sum/2){
            if(max == sum/2){
                System.out.println("before");
                return true;
            }else{
                return false;
            }
        }
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length][sum];
        dp[0][nums[0]] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j <= target; j++){
                if(dp[i-1][j] == true){
                    dp[i][j] = true;
                    dp[i][j+nums[i]] = true;
                    if(j + nums[i] == target){
                        System.out.println("here");
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
