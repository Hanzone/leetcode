package problems.algorithms.p46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> single, int[] nums) {
        if (nums.length == 0) {
            res.add(single);
        }

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> newSingle = new ArrayList<>(single);
            newSingle.add(nums[i]);
            int[] subNums = Arrays.copyOf(nums, nums.length - 1);
            System.arraycopy(nums, i + 1, subNums, i, nums.length - i - 1);
            helper(res, newSingle, subNums);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> answer = permutations.permute(new int[]{1, 2, 3});
        String expect = "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]";
        printAnswerAndExpect(answer, expect);
    }
}
