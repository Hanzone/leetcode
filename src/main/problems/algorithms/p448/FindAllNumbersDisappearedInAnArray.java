package problems.algorithms.p448;

import java.util.ArrayList;
import java.util.List;

import static utils.PrintUtils.print;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            // mark appearance
            nums[index - 1] = -Math.abs(nums[index - 1]);
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                results.add(i+1);
            }
        }
        return results;

    }

    public static void main(String[] args) {
        List<Integer> numbers = new FindAllNumbersDisappearedInAnArray()
                .findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        print(numbers);
    }
}
