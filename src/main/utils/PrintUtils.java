package utils;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class PrintUtils {

    private static final String space = "      ";

    public static void print(Object o) {
        out.println(o);
    }

    public static void print(int[] o) {
        print(Arrays.stream(o).boxed().collect(Collectors.toList()));
    }

    public static void print(int[][] o) {
        print(Arrays.stream(o).map(ints -> Arrays.stream(ints).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList()));
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
        print("Answer is: " + answer);
        print("Expect is: " + expect);
    }

    public static void printAnswerAndExpect(int[] answer, int[] expect) {
        print("Answer is: " + Arrays.stream(answer).boxed().collect(Collectors.toList()));
        print("Expect is: " + Arrays.stream(expect).boxed().collect(Collectors.toList()));
    }

    public static void printAnswerAndExpect(int[][] answer, int[][] expect) {
        print("Answer is: " + Arrays.stream(answer)
                .map(ints -> Arrays.stream(ints).boxed().collect(Collectors.toList())).collect(Collectors.toList()));
        print("Expect is: " + Arrays.stream(expect)
                .map(ints -> Arrays.stream(ints).boxed().collect(Collectors.toList())).collect(Collectors.toList()));
    }
}
