package problems.algorithms.p1262;

public class GreatestSumDivisibleByThree {

    /**
     * Given an array nums of integers,
     * we need to find the maximum possible sum of elements of the array such that it is divisible by three.
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        final int MAX = 10001;
        int leftOne1 = MAX;
        int leftOne2 = MAX;
        int leftTwo1 = MAX;
        int leftTwo2 = MAX;

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                if (num < leftOne2) {
                    if (num < leftOne1) {
                        leftOne2 = leftOne1;
                        leftOne1 = num;
                    } else {
                        leftOne2 = num;
                    }
                }
            }
            if (num % 3 == 2) {
                if (num < leftTwo2) {
                    if (num < leftTwo1) {
                        leftTwo2 = leftTwo1;
                        leftTwo1 = num;
                    } else {
                        leftTwo2 = num;
                    }
                }
            }
        }

        if (sum % 3 == 1 && leftOne1 < MAX) {
            sum -= Math.min(leftOne1, leftTwo1 + leftTwo2);
        }
        if (sum % 3 == 2 && leftTwo1 < MAX) {
            sum -= Math.min(leftTwo1, leftOne1 + leftOne2);
        }

        return sum;
    }


    /**
     * Input: nums = [3,6,5,1,8]
     * Output: 18
     * @param args
     */
    public static void main(String[] args) {
        int sum = new GreatestSumDivisibleByThree().maxSumDivThree(new int[]{3, 6, 5, 1, 8});
        System.out.println(sum);
    }

}
