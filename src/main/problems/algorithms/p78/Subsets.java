package problems.algorithms.p78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0, nums.length - 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> path, int[] nums, int from, int to) {
        if (from > to) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // path 1: not add this value
        backtrack(ans, path, nums, from + 1, to);

        // path 2: add this value
        path.add(nums[from]);
        backtrack(ans, path, nums, from + 1, to);
        path.remove(path.size() - 1);
    }



    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> answer = subsets.subsets(new int[]{1, 2, 3});

        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList());
        expect.add(Arrays.asList(1));
        expect.add(Arrays.asList(2));
        expect.add(Arrays.asList(3));
        expect.add(Arrays.asList(1, 2));
        expect.add(Arrays.asList(1, 3));
        expect.add(Arrays.asList(2, 3));
        expect.add(Arrays.asList(1, 2, 3));
        printAnswerAndExpect(answer, expect);
    }

}
