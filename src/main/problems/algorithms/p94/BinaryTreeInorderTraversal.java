package problems.algorithms.p94;

import utils.PrintUtils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

//        return recursively(new ArrayList<>(), root);
        return iteratively(new ArrayList<>(), root);
    }

    private List<Integer> recursively(List<Integer> values, TreeNode root) {
        if (root == null) {
            return values;
        }

        recursively(values, root.left);
        values.add(root.val);
        recursively(values, root.right);
        return values;
    }

    /**
     * Use stack to simulate recursive.
     * @param values
     * @param root
     * @return
     */
    private List<Integer> iteratively(List<Integer> values, TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left; // keep pushing left to stack, which pop-and-add first
            }
            curr = stack.pop();
            values.add(curr.val);
            curr = curr.right; // treat right subtree as a new tree
        }

        return values;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> answer = traversal.inorderTraversal(root);
        PrintUtils.printAnswerAndExpect(answer, Arrays.asList(1, 3, 2));
    }

}
