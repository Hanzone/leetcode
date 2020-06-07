package problems.concurrency.p1115;

import java.util.concurrent.Semaphore;

/**
 * Suppose you are given the following code:
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * The same instance of FooBar will be passed to two different threads.
 * Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously.
 * One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * Example 2:
 *
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 */
public class PrintFooBarAlternately {

    public static void main(String[] args) throws InterruptedException {

        // case 1
        FooBar fooBar1 = new FooBar(1);
        new Thread(() -> {
            try {
                fooBar1.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar1.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000L);
        System.out.println();

        // case 2
        FooBar fooBar2 = new FooBar(2);
        new Thread(() -> {
            try {
                fooBar2.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar2.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static class FooBar {
        private final int n;
        private final Semaphore semaphoreFoo = new Semaphore(1);
        private final Semaphore semaphoreBar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphoreFoo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                semaphoreBar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphoreBar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                semaphoreFoo.release();
            }
        }
    }

}


