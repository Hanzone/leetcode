package problems.algorithms.p105;

import utils.PrintUtils;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * @param preorder [root, left-preorder, right-preorder]
     * @param inorder [left-inorder, root, right-inorder]
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(inorderMap, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(Map<Integer, Integer> inorderMap,
                            int[] preorder, int preLeft, int preRight,
                            int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        Integer inRootIndex = inorderMap.get(preorder[preLeft]);
        int leftLength = inRootIndex - inLeft;

        TreeNode root = new TreeNode(preorder[preLeft]);
        // recurse left
        root.left = helper(inorderMap,
                preorder, preLeft + 1, preLeft + leftLength,
                inorder, inLeft, inLeft + leftLength - 1);
        // recurse right
        root.right = helper(inorderMap,
                preorder, preLeft + leftLength + 1, preRight,
                inorder, inLeft + leftLength + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal traversal
                = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = traversal.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        PrintUtils.print(root);
    }

}
