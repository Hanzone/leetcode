package problems.algorithms.p7;

import java.util.Stack;

import static utils.PrintUtils.print;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment
 * which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {


    public int reverse(int x) {
        // check and init
        int symbol = 1;
        long longX = x;
        if (longX < 0) {
            symbol = -1;
            longX = -longX;
        }

        // stored in stack
        Stack<Integer> stack = new Stack<>();
        while (longX != 0) {
            stack.push((int) (longX % 10));
            longX = longX / 10;
        }

        // calculate reversed value
        long reverse = 0;
        long multiply = 1;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            reverse += multiply * pop;
            multiply *= 10;
        }

        return reverse > Integer.MAX_VALUE ? 0 : (int)reverse * symbol;
    }

    public static void main(String[] args) {
        print(new ReverseInteger().reverse(Integer.MAX_VALUE));
        print(new ReverseInteger().reverse(-2147483648));
        print(new ReverseInteger().reverse(123));
        print(new ReverseInteger().reverse(-123));
        print(new ReverseInteger().reverse(120));
    }

}
