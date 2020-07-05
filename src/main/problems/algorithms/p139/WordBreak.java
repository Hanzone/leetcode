package problems.algorithms.p139;

import utils.PrintUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        // dp[i+1] = (dp[0] && wordDict.contains(s.substring(0, i+1)))
        // || (dp[1] && wordDict.contains(s.substring(1, i+1)))
        // || ...
        // || (dp[i] && wordDict.contains(s.substring.(i, i+1)))
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }

        return breakable[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreaker = new WordBreak();

        boolean answer1 = wordBreaker.wordBreak("leetcode", Arrays.asList("leet", "code"));
        PrintUtils.printAnswerAndExpect(answer1, true);
        boolean answer2 = wordBreaker.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        PrintUtils.printAnswerAndExpect(answer2, true);
        boolean answer3 = wordBreaker.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        PrintUtils.printAnswerAndExpect(answer3, false);
    }

}
