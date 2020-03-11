package problems.algorithms.p118;

import java.util.ArrayList;
import java.util.List;

import static utils.PrintUtils.print;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        List<Integer> last = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> current = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (last.size() == 0) {
                    current.add(j, 1);
                } else {
                    int left = (j - 1) < 0 ? 0 : last.get(j - 1);
                    int right = j >= last.size() ? 0 : last.get(j);
                    current.add(j, left + right);
                }
            }
            triangle.add(current);
            last = current;
        }
        return triangle;
    }

    public static void main(String[] args) {
        print(new PascalTriangle().generate(5));
    }

}
