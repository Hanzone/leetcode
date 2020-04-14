package problems.algorithms.p75;

import static utils.PrintUtils.printAnswerAndExpect;
/**
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        // judge mid
        while (mid <= right) {
            if (nums[mid] == 0) {
                nums[mid] = nums[left];
                nums[left] = 0;
                left++;
                // left of mid already judged
                mid++;
            } else if (nums[mid] == 2) {
                nums[mid] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] answer1 = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(answer1);
        int[] expect1 = {0, 0, 1, 1, 2, 2};
        printAnswerAndExpect(answer1, expect1);

        int[] answer2 = {1, 2, 0};
        sortColors.sortColors(answer2);
        int[] expect2 = {0, 1, 2};
        printAnswerAndExpect(answer2, expect2);
    }

}
