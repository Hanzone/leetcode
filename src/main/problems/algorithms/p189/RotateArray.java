package problems.algorithms.p189;

import java.util.Arrays;
import java.util.stream.Collectors;

import static utils.PrintUtils.print;
/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || (k = k % nums.length) == 0) {
            return;
        }
        reverseArray(nums, 0, nums.length - k - 1);
        reverseArray(nums, nums.length - k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    private void reverseArray(int[] nums, int left, int right) {
        for (int i = 0; i < (right - left + 1) / 2; i++) {
            int temp = nums[left + i];
            nums[left + i] = nums[right - i];
            nums[right - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] t1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(t1, 3);
        print(Arrays.stream(t1).boxed().collect(Collectors.toList()));

        int[] t2 = new int[]{-1, -100, 3, 99};
        new RotateArray().rotate(t2, 2);
        print(Arrays.stream(t2).boxed().collect(Collectors.toList()));

        int[] t3 = new int[]{1, 2};
        new RotateArray().rotate(t3, 1);
        print(Arrays.stream(t3).boxed().collect(Collectors.toList()));
    }

}
