package problems.algorithms.p53;

import static utils.PrintUtils.print;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    /**
     * using dp solution
     * @param nums given integer array nums
     * @return contiguous subarray's sum
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i] means maxSubArray value end with nums[i];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // max means maxSubArray value
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // means maxSubArray value must in dp[0] ~ dp[nums.length - 1]
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        int max = new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        print(max);

    }

}
