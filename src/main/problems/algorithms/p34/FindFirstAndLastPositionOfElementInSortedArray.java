package problems.algorithms.p34;

import java.util.Arrays;
import java.util.stream.Collectors;

import static utils.PrintUtils.printAnswerAndExpect;
/**
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index;
        int right = index;
        if (nums.length >= 2) {
            while (left >= 1) {
                if (nums[left - 1] == nums[left]) {
                    left--;
                    continue;
                }
                break;
            }
            while (right <= nums.length - 2) {
                if (nums[right] == nums[right + 1]) {
                    right++;
                    continue;
                }
                break;
            }
        }

        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray finder = new FindFirstAndLastPositionOfElementInSortedArray();

        int[] answer1 = finder.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        printAnswerAndExpect(Arrays.stream(answer1).boxed().collect(Collectors.toList()), Arrays.asList(3, 4));

        int[] answer2 = finder.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        printAnswerAndExpect(Arrays.stream(answer2).boxed().collect(Collectors.toList()), Arrays.asList(-1, -1));
    }
}
