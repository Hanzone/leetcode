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

    public static void print(ListNode listNode) {
        if (listNode == null) {
            print("null");
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(listNode.val));
        ListNode p = listNode.next;
        while (p != null) {
            sb.append("->").append(p.val);
            p = p.next;
        }
        print(sb);
    }

    private static void print(TreeNode node, int deep) {
        if (node == null) {
            printSpace(deep);
            print("#");
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
        print(res);
    }

    public static void printAnswerAndExpect(Object answer, Object expect) {
        print("Answer is: " + answer + "  Expect: " + expect);
    }

}
