package problems.algorithms.p108;

import utils.TreeNode;

import static utils.PrintUtils.print;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // choose mid or mid-left as root
        int rootIndex = (left + right) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, left , rootIndex - 1);
        root.right = helper(nums, rootIndex + 1 , right);

        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree convert = new ConvertSortedArrayToBinarySearchTree();
        print(convert.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

}
