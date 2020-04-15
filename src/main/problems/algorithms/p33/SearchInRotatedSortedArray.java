package problems.algorithms.p33;

import static utils.PrintUtils.printAnswerAndExpect;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // lo<->mid in order?
            if (nums[lo] <= nums[mid]) {
                // decide target in which side, by comparing in sorted side(lo <-> mid)
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // decide target in which side, by comparing in sorted side(mid <-> hi)
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

        int answer1 = searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        printAnswerAndExpect(answer1, 4);

        int answer2 = searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        printAnswerAndExpect(answer2, -1);
    }
}
