package problems.algorithms.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        // helps prune
        Arrays.sort(candidates);

        backTrack(ans, candidates, 0, candidates.length - 1, new ArrayList<>(), target);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, int[] candidates, int from, int to, List<Integer> sub, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(sub));
        }

        for (int i = from; i <= to; i++) {
            // prune
            if (candidates[i] > target) {
                break;
            }
            sub.add(candidates[i]);
            backTrack(ans, candidates, i, to, sub, target - candidates[i]);
            sub.remove(sub.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> answer1 = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        String expect1 = "[[7], [2, 2, 3]]";
        printAnswerAndExpect(answer1, expect1);

        List<List<Integer>> answer2 = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);
        String expect2 = "[[2, 2, 2, 2], [2, 3, 3], [3, 5]]";
        printAnswerAndExpect(answer2, expect2);
    }

}
