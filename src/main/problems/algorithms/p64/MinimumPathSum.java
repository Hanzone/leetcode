package problems.algorithms.p64;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

//        int[][] minGrid = new int[grid.length][grid[0].length];
        int[][] minGrid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    minGrid[i][j] = grid[i][j];
                } else if (i == 0) {
                    minGrid[i][j] = minGrid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    minGrid[i][j] = minGrid[i - 1][j] + grid[i][j];
                } else {
                    // dp: minSum = min(left, top) + val
                    minGrid[i][j] = Math.min(minGrid[i][j - 1], minGrid[i - 1][j]) + grid[i][j];
                }
            }
        }

        return minGrid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int answer = minimumPathSum.minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}});
        int expect = 7;
        printAnswerAndExpect(answer, expect);
    }

}
