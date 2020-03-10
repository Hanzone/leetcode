package problems.algorithms.p202;

import java.util.HashSet;
import java.util.Set;

import static utils.PrintUtils.print;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 *      Starting with any positive integer,
 *      replace the number by the sum of the squares of its digits,
 *      and repeat the process until the number equals 1 (where it will stay),
 *      or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        Set<Integer> appeared = new HashSet<>();
        appeared.add(n);
        while (n > 1) {
            n = getNext(n);
            if (appeared.contains(n)) {
                return false;
            } else {
                appeared.add(n);
            }
        }

        return true;
    }

    private int getNext(int n) {
        int nextSum = 0;
        while (n != 0) {
            int i = n % 10;
            nextSum += i * i;
            n = n / 10;
        }
        return nextSum;
    }

    public static void main(String[] args) {
        boolean happy = new HappyNumber().isHappy(19);
        print(happy);
    }

}
