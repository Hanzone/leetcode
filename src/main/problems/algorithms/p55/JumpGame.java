package problems.algorithms.p55;

import static utils.PrintUtils.printAnswerAndExpect;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        boolean[] arrived = new boolean[nums.length];
        arrived[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (arrived[i]) {
                // mark arrived from index i
                for (int j = i + 1; j <= (i + nums[i]) && j < nums.length; j++) {
                    if (!arrived[j]) {
                        arrived[j] = true;
                    }
                }
            }
        }

        return arrived[nums.length - 1];
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int max = 0;
        for (int i = 0; i < nums.length && max < (nums.length - 1); i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        boolean answer1 = jumpGame.canJump(new int[]{2, 3, 1, 1, 4});
        boolean answer2 = jumpGame.canJump(new int[]{3, 2, 1, 0, 4});
        printAnswerAndExpect(answer1, true);
        printAnswerAndExpect(answer2, false);

        boolean answer3 = jumpGame.canJump2(new int[]{2, 3, 1, 1, 4});
        boolean answer4 = jumpGame.canJump2(new int[]{3, 2, 1, 0, 4});
        printAnswerAndExpect(answer3, true);
        printAnswerAndExpect(answer4, false);
    }

}
