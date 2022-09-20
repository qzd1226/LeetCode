package ByteDance;

public class Q1 {
    public static void main(String[] args) {
        int[] test = {0,1,0,0,1};
        System.out.println(hasKZeros(test,1,4,2));

    }
    public static boolean hasKZeros(int[] nums, int start, int end, int k){
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int diff = sum[end] - sum[start];
        return ((end - start) - k == diff);
    }
}
