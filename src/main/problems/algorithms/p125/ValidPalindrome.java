package problems.algorithms.p125;


import java.util.Deque;
import java.util.LinkedList;

import static utils.PrintUtils.print;


/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // handle alphanumeric characters and ignoring cases
        int caseOffset = 'a' - 'A';
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (('a' <= c && c <= 'z')) {
                deque.add((char) (c - caseOffset));
            }
            if (('A' <= c && c <= 'Z')) {
                deque.add(c);
            }
            if (('0' <= c && c <= '9')) {
                deque.add(c);
            }
        }

        // judge
        while (!deque.isEmpty()) {
            Character first = deque.pollFirst();
            Character last = deque.pollLast();
            if (first != null && last != null && first != last) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        print(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        print(new ValidPalindrome().isPalindrome("race a car"));
        print(new ValidPalindrome().isPalindrome("0P"));
    }
}
