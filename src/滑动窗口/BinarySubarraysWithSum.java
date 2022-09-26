package 滑动窗口;
//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
//        子数组 是数组的一段连续部分。
//        示例 1：
//        输入：nums = [1,0,1,0,1], goal = 2
//        输出：4
//        解释：
//        有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
//        示例 2：
//        输入：nums = [0,0,0,0,0], goal = 0
//        输出：15

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] test = {1,0,1,0,1};
        int ans = 0;
        ans = numSubarraysWithSum1(test, 2);
        System.out.println("ans:" + ans);
    }
    // 滑动窗口
    // 时间：O(n)，空间：O(1)
    public static int numSubarraysWithSum1(int[] nums, int goal) {
        int n = nums.length, ans = 0;
        // 维持两个窗口：[l ... r1],[l ... r2]窗口内累加和分别为sum1,sum2，r1、r2分别为以l为左端点且累加和等于goal的子数组右边界范围，r2-r2即为以l为左边界满足条件的子数组个数
        int l = 0, r1 = 0, r2 = 0, sum1 = 0, sum2 = 0;
        while (l < n) {
            if (r1 < l) r1 = l;
            if (r2 < l) r2 = l;
            while (r1 < n && sum1 + nums[r1] < goal) {
                sum1 += nums[r1];
                r1++;
            }
            while (r2 < n && sum2 + nums[r2] <= goal) {
                sum2 += nums[r2];
                r2 ++;
            }
            ans += r2- r1;
            if (l < r1) sum1 -= nums[l];
            if (l < r2) sum2 -= nums[l];
            l++;
        }
        return ans;
    }
}

