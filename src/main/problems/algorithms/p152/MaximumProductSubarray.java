package problems.algorithms.p152;

import utils.PrintUtils;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        // use o(n) space, more readable
        // can be o(1)
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];

        int maxProduct = nums[0];
        // use dp
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] <= 0) {
                min[i] = Math.min(max[i-1] * nums[i], nums[i]);
                max[i] = Math.max(min[i-1] * nums[i], nums[i]);
            } else {
                min[i] = Math.min(min[i-1] * nums[i], nums[i]);
                max[i] = Math.max(max[i-1] * nums[i], nums[i]);
            }
            maxProduct = Math.max(maxProduct, max[i]);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums1 = new int[]{2, 3, -2, 4};
        int maxProduct1 = maximumProductSubarray.maxProduct(nums1);
        PrintUtils.printAnswerAndExpect(maxProduct1, 6);

        int[] nums2 = new int[]{-2, 0, -1};
        int maxProduct2 = maximumProductSubarray.maxProduct(nums2);
        PrintUtils.printAnswerAndExpect(maxProduct2, 0);
    }
}
