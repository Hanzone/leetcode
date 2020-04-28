package problems.algorithms.p56;

import java.util.Arrays;
import java.util.Comparator;

import static utils.PrintUtils.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019.
 * Please reset to default code definition to get new method signature.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // sort
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int min = intervals[0][0];
        int max = intervals[0][1];
        int[][] ans = new int[intervals.length][];
        int ansIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            // can't merge
            if (intervals[i][0] > max) {
                ans[ansIndex++] = new int[]{min, max};
                min = intervals[i][0];
                max = intervals[i][1];
            } else {
                // merge
                max = Math.max(max, intervals[i][1]);
            }
        }
        // add last intervals
        ans[ansIndex++] = new int[]{min, max};
        return Arrays.copyOfRange(ans, 0, ansIndex);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int[][] input1 = {
                new int[]{2, 6},
                new int[]{1, 3},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        int[][] expect1 = {
                new int[]{1, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        int[][] answer1 = mergeIntervals.merge(input1);
        printAnswerAndExpect(answer1, expect1);

        int[][] input2 = {
                new int[]{1, 4},
                new int[]{4, 5}
        };
        int[][] expect2 = {
                new int[]{1, 5}
        };
        int[][] answer2 = mergeIntervals.merge(input2);
        printAnswerAndExpect(answer2, expect2);
    }

}
