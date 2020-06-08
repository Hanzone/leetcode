package problems.concurrency.p1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Suppose you are given the following code:
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // constructor
 *   public void zero(printNumber) { ... }  // only output 0's
 *   public void even(printNumber) { ... }  // only output even numbers
 *   public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 *
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the threads is given a printNumber method to output an integer.
 * Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously.
 * One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * Example 2:
 *
 * Input: n = 5
 * Output: "0102030405"
 */
public class PrintZeroEvenOdd {

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd2 = new ZeroEvenOdd(2);
        new Thread(() -> {
            try {
                zeroEvenOdd2.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd2.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd2.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000L);
        System.out.println();

        ZeroEvenOdd zeroEvenOdd5 = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd5.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd5.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd5.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static class ZeroEvenOdd {
        private final int n;
        private final Semaphore semaphoreZero;
        private final Semaphore semaphoreEven;
        private final Semaphore semaphoreOdd;

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.semaphoreZero = new Semaphore(1);
            this.semaphoreEven = new Semaphore(0);
            this.semaphoreOdd = new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                semaphoreZero.acquire();
                printNumber.accept(0);
                if (i % 2 == 1) {
                    semaphoreOdd.release();
                } else {
                    semaphoreEven.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i = i + 2) {
                semaphoreEven.acquire();
                printNumber.accept(i);
                semaphoreZero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i = i + 2) {
                semaphoreOdd.acquire();
                printNumber.accept(i);
                semaphoreZero.release();
            }
        }
    }
}
