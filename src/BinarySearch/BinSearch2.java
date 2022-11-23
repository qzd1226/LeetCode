package BinarySearch;

public class BinSearch2 {
    public static void main(String[] args) {
        //int[] nums = {4,8,8,8,10,12};
        int[] nums = {4, 8, 9};
        // find the index of num who > 5
        int target = 5;
        int ans = findSmallest(nums, target);
        System.out.println("ans:" + ans);
    }

    public static int findSmallest(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        int len = nums.length;
        if (len == 0) {

            return -1;
         }
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target && nums[mid - 1] < target) {
                right = mid;
            } else {
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (nums[right] >= target && nums[right - 1] < target) {
            return right;
        }
        if (nums[left] >= target && nums[left - 1] < target) {
            return left;
        }
        return -2;
    }
}
