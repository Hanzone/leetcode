package problems.algorithms.p102;

import utils.PrintUtils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(root, answer, 0);
        return answer;
    }

    private void helper(TreeNode root, List<List<Integer>> answer, int depthIndex) {
        if (root == null) {
            return;
        }

        if (depthIndex > answer.size() - 1) {
            answer.add(new ArrayList<>());
        }
        answer.get(depthIndex).add(root.val);
        helper(root.left, answer, depthIndex + 1);
        helper(root.right, answer, depthIndex + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> answer = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        List<List<Integer>> expect = Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7));
        PrintUtils.printAnswerAndExpect(answer, expect);
    }

}
