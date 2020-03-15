package problems.algorithms.p581;

import java.util.Arrays;

import static utils.PrintUtils.print;

/**
 * Given an integer array,
 * you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] origins = new int[length];
        System.arraycopy(nums, 0, origins, 0, length);
        Arrays.sort(nums);
        int min = 0;
        int max = length - 1;

        for (int i = 0; i < length; i++) {
            if (nums[i] == origins[i]) {
                min++;
            } else {
                break;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == origins[i]) {
                max--;
            } else {
                break;
            }
        }

        return min == length && max == -1 ? 0 : max - min + 1;
    }

    public static void main(String[] args) {
        print(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        print(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        print(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 2, 4, 3}));
    }

}
