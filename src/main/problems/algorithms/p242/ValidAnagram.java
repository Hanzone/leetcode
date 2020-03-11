package problems.algorithms.p242;

import static utils.PrintUtils.print;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        int[] sTable = new int[26];
        int[] tTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sTable[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tTable[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sTable[i] != tTable[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        print(new ValidAnagram().isAnagram("anagram", "nagaram"));
        print(new ValidAnagram().isAnagram("rat", "car"));
    }

}
