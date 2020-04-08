package problems.algorithms.p22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        helper(ans, "", n, n);
        return ans;
    }

    private void helper(List<String> ans, String subAns, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(subAns);
        }

        if (left > 0) {
            helper(ans, subAns + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            helper(ans, subAns + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> answer = generateParentheses.generateParenthesis(3);

        List<String> expect = Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        );
        printAnswerAndExpect(answer, expect);
    }
}
