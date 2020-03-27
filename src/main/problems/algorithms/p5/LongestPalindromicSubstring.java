package problems.algorithms.p5;

import static utils.PrintUtils.print;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String longest = "";
        // center on single char
        for (int i = 0; i < s.length(); i++) {
            String tempLongest = max(s, i, i);
            if (longest.length() < tempLongest.length()) {
                longest = tempLongest;
            }
        }
        // center on double chars
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                String tempLongest = max(s, i, i + 1);
                if (longest.length() < tempLongest.length()) {
                    longest = tempLongest;
                }
            }
        }

        return longest;
    }

    private String max(String s, int left, int right) {
        while (left - 1 >= 0 && right + 1 <= s.length() - 1) {
            if (s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        print(longestPalindromicSubstring.longestPalindrome("babad"));
        print(longestPalindromicSubstring.longestPalindrome("bb"));
        print(longestPalindromicSubstring.longestPalindrome("b"));
        print(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

}
