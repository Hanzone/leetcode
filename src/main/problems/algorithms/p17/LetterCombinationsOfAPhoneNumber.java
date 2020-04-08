package problems.algorithms.p17;

import java.util.*;

import static utils.PrintUtils.printAnswerAndExpect;
/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    private static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        helper(res, "", digits);
        return res;
    }

    private void helper(List<String> res, String subResStr, String subDigits) {
        if (subDigits.length() == 0) {
            res.add(subResStr);
            return;
        }

        String letters = map.get(subDigits.charAt(0));
        for (int i = 0; i < letters.length(); i++) {
            helper(res, subResStr + letters.charAt(i), subDigits.substring(1));
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> res = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        printAnswerAndExpect(res, expect);
    }
}
