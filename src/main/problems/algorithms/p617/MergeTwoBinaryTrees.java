package problems.algorithms.p617;

import utils.PrintUtils;
import utils.TreeNode;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode mergeNode = new TreeNode(t1.val + t2.val);
        mergeNode.left = mergeTrees(t1.left, t2.left);
        mergeNode.right = mergeTrees(t1.right, t2.right);
        return mergeNode;
    }

    /**
     *     Input:
     *     Tree 1                     Tree 2
     *             1                         2
     *             / \                       / \
     *             3   2                     1   3
     *             /                           \   \
     *             5                             4   7
     *     Output:
     *     Merged tree:
     *             3
     *             / \
     *             4   5
     *             / \   \
     *             5   4   7
     * @param args
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode treeNode = new MergeTwoBinaryTrees().mergeTrees(t1, t2);
        PrintUtils.print(treeNode);
    }

}
