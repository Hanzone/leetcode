package problems.algorithms.p96;

import utils.PrintUtils;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[n] = dp[0]*dp[n-1] + dp[0]*dp[n-1] + ··· + dp[n-1]*dp[0]
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        PrintUtils.printAnswerAndExpect(uniqueBinarySearchTrees.numTrees(0), 0);
        PrintUtils.printAnswerAndExpect(uniqueBinarySearchTrees.numTrees(1), 1);
        PrintUtils.printAnswerAndExpect(uniqueBinarySearchTrees.numTrees(2), 2);
        PrintUtils.printAnswerAndExpect(uniqueBinarySearchTrees.numTrees(3), 5);
        PrintUtils.printAnswerAndExpect(uniqueBinarySearchTrees.numTrees(4), 14);
    }
}
