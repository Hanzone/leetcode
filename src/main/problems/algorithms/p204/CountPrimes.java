package problems.algorithms.p204;

import static utils.PrintUtils.print;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        if (n == 3) return 1;
        if (n == 4) return 2;

        boolean[] primeRecord = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                primeRecord[i * j] = true;
            }
        }

        int count = 2;
        for (int i = 4; i < n; i++) {
            if (!primeRecord[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        print(new CountPrimes().countPrimes(1));
        print(new CountPrimes().countPrimes(2));
        print(new CountPrimes().countPrimes(3));
        print(new CountPrimes().countPrimes(5));
        print(new CountPrimes().countPrimes(10));
    }
}
