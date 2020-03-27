package problems.algorithms.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);

        // single list contains [left, middle, right]
        for (int left = 0; left <= nums.length - 3;) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }

            int middle = left + 1;
            int right = nums.length - 1;

            while (middle < right) {
                if (middle > left + 1 && nums[middle] == nums[middle - 1]) {
                    middle++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }

                int sum = nums[left] + nums[middle] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[left], nums[middle], nums[right]));
                    middle++;
                }
                if (sum < 0) {
                    middle++;
                }
                if (sum > 0) {
                    right--;
                }
            }

            left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> sums = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        printAnswerAndExpect(sums, "[[-1, 0, 1], [-1, -1, 2]]");
    }
}
