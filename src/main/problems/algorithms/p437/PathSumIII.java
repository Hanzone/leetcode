package problems.algorithms.p437;

import utils.TreeNode;

import static utils.PrintUtils.print;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {

    private int sumPath = 0;

    public int pathSum(TreeNode root, int sum) {
        startWithRoot(root, sum);
        return sumPath;
    }

    private void startWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        helper(root, sum);
        startWithRoot(root.left, sum);
        startWithRoot(root.right, sum);
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.val == sum) {
            sumPath++;
        }
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        PathSumIII pathSumIII = new PathSumIII();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        print(pathSumIII.pathSum(root, 8));
    }

}
