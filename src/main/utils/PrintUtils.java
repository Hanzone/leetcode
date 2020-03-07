package utils;

import static java.lang.System.out;

public class PrintUtils {

    private static final String space = "      ";

    public static void print(Object o) {
        out.println(o);
    }

    /**
     * 竖向打印二叉树
     *
     * @param root 二叉树根节点
     */
    public static void print(TreeNode root) {
        print(root, 0);
    }

    private static void print(TreeNode node, int deep) {
        if (node == null) {
            printSpace(deep);
            out.println("#");
            return;
        }
        print(node.right, deep + 1);
        printSpace(deep);
        printNode(node.val);
        print(node.left, deep + 1);
    }

    private static void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            out.printf(space);
        }
    }

    private static void printNode(int val) {
        StringBuilder res = new StringBuilder(val + "<");
        int spaceNum = space.length() - res.length();
        for (int i = 0; i < spaceNum; i++) {
            res.append(" ");
        }
        out.println(res);
    }

}
