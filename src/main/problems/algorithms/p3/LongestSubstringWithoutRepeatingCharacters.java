package problems.algorithms.p3;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int max = 0;
        // slide window
        for (int i = 0; i < s.length() && left < s.length() && right <= s.length(); i++) {
            int index = s.indexOf(s.charAt(i), left);
            if (index < 0 || index >= right) {
                right++;
                max = Math.max(max, right - left);
            } else {
                left = index + 1;
                right++;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters computer = new LongestSubstringWithoutRepeatingCharacters();
        printAnswerAndExpect(computer.lengthOfLongestSubstring("abcabcbb"), 3);
        printAnswerAndExpect(computer.lengthOfLongestSubstring("bbbbb"), 1);
        printAnswerAndExpect(computer.lengthOfLongestSubstring("pwwkew"), 3);

    }

}
