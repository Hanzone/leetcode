package problems.algorithms.p114;

import utils.PrintUtils;
import utils.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            TreeNode curr = root.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    public static void main(String[] args) {

        FlattenBinaryTreeToLinkedList flattener = new FlattenBinaryTreeToLinkedList();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flattener.flatten(root);

        TreeNode expect = new TreeNode(1);
        expect.right = new TreeNode(2);
        expect.right.right = new TreeNode(3);
        expect.right.right.right = new TreeNode(4);
        expect.right.right.right.right = new TreeNode(5);
        expect.right.right.right.right.right = new TreeNode(6);

        PrintUtils.printAnswerAndExpect(root, expect);
    }

}
