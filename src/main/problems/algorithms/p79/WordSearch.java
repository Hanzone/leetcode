package problems.algorithms.p79;

import utils.PrintUtils;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        final int m = board.length;
        final int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, visited, m, n, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, int m, int n, int i, int j,
                              String word, int checkIndex) {
        if (word.length() == checkIndex) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(checkIndex)) {
            return false;
        }

        visited[i][j] = true;
        if (backtrack(board, visited, m, n, i - 1, j, word, checkIndex + 1)
                || backtrack(board, visited, m, n, i + 1, j, word, checkIndex + 1)
                || backtrack(board, visited, m, n, i, j - 1, word, checkIndex + 1)
                || backtrack(board, visited, m, n, i, j + 1, word, checkIndex + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };
        boolean answer1 = wordSearch.exist(board, "ABCCED");
        boolean answer2 = wordSearch.exist(board, "SEE");
        boolean answer3 = wordSearch.exist(board, "ABCB");

        PrintUtils.printAnswerAndExpect(answer1, true);
        PrintUtils.printAnswerAndExpect(answer2, true);
        PrintUtils.printAnswerAndExpect(answer3, false);
    }
}
