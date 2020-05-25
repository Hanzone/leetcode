package problems.concurrency.p1114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static utils.PrintUtils.print;

/**
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(),
 * and third() is executed after second().
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously.
 * The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third().
 * "firstsecondthird" is the correct output.
 *
 *
 * Example 2:
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second().
 * "firstsecondthird" is the correct output.
 *
 *
 * Note:
 *
 * We do not know how the threads will be scheduled in the operating system,
 * even though the numbers in the input seems to imply the ordering.
 * The input format you see is mainly to ensure our tests' comprehensiveness.
 */
public class PrintInOrder {

    public void first(Runnable printFirst) throws InterruptedException {
        throw new RuntimeException("forbidden");
    }

    public void second(Runnable printSecond) throws InterruptedException {
        throw new RuntimeException("forbidden");
    }

    public void third(Runnable printThird) throws InterruptedException {
        throw new RuntimeException("forbidden");
    }

    private static class CountDownLatchFoo extends PrintInOrder {

        private final CountDownLatch countDownLatch2 = new CountDownLatch(1);
        private final CountDownLatch countDownLatch3 = new CountDownLatch(1);

        public CountDownLatchFoo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatch2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            countDownLatch2.await();
            printSecond.run();
            countDownLatch3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            countDownLatch3.await();
            printThird.run();
        }

    }

    private static class SemaphoreFoo extends PrintInOrder {

        private final Semaphore semaphore2 = new Semaphore(0);
        private final Semaphore semaphore3 = new Semaphore(0);

        public SemaphoreFoo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            semaphore2.acquire();
            printSecond.run();
            semaphore3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            semaphore3.acquire();
            printThird.run();
        }

    }

    private static class AtomicIntegerFoo extends PrintInOrder {

        private final AtomicInteger atomicInteger = new AtomicInteger(0);

        public AtomicIntegerFoo() {

        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            atomicInteger.getAndIncrement();
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while (atomicInteger.get() != 1) {
                wait();
            }
            printSecond.run();
            atomicInteger.getAndIncrement();
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            while (atomicInteger.get() != 2) {
                wait();
            }
            printThird.run();
        }

    }

    private static class CASFoo extends PrintInOrder {

        private final AtomicInteger atomicInteger = new AtomicInteger(0);

        public CASFoo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            while (!atomicInteger.compareAndSet(0, 1)) {
            }
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while (!atomicInteger.compareAndSet(1, 2)) {
            }
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            while (!atomicInteger.compareAndSet(2, 3)) {
            }
            printThird.run();
        }

    }

    private static Thread firstThread(PrintInOrder printInOrder) {
        return new Thread(() -> {
            try {
                printInOrder.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static Thread secondThread(PrintInOrder printInOrder) {
        return new Thread(() -> {
            try {
                printInOrder.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static Thread thirdThread(PrintInOrder printInOrder) {
        return new Thread(() -> {
            try {
                printInOrder.third(() -> print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {

        testCountDownLatchFoo1();
        Thread.sleep(1000L);
        testCountDownLatchFoo2();
        Thread.sleep(1000L);

        testSemaphoreFoo1();
        Thread.sleep(1000L);
        testSemaphoreFoo2();
        Thread.sleep(1000L);

        testAtomicIntegerFoo1();
        Thread.sleep(1000L);
        testAtomicIntegerFoo2();
        Thread.sleep(1000L);

        testCASFoo1();
        Thread.sleep(1000L);
        testCASFoo2();
        Thread.sleep(1000L);
    }

    private static void testCountDownLatchFoo1() throws InterruptedException {
        CountDownLatchFoo countDownLatchFoo = new CountDownLatchFoo();
        firstThread(countDownLatchFoo).start();
        Thread.sleep(100L);
        secondThread(countDownLatchFoo).start();
        Thread.sleep(100L);
        thirdThread(countDownLatchFoo).start();
    }

    private static void testCountDownLatchFoo2() throws InterruptedException {
        CountDownLatchFoo countDownLatchFoo = new CountDownLatchFoo();
        firstThread(countDownLatchFoo).start();
        Thread.sleep(100L);
        thirdThread(countDownLatchFoo).start();
        Thread.sleep(100L);
        secondThread(countDownLatchFoo).start();
    }

    private static void testSemaphoreFoo1() throws InterruptedException {
        SemaphoreFoo semaphoreFoo = new SemaphoreFoo();
        firstThread(semaphoreFoo).start();
        Thread.sleep(100L);
        secondThread(semaphoreFoo).start();
        Thread.sleep(100L);
        thirdThread(semaphoreFoo).start();
    }

    private static void testSemaphoreFoo2() throws InterruptedException {
        SemaphoreFoo semaphoreFoo = new SemaphoreFoo();
        firstThread(semaphoreFoo).start();
        Thread.sleep(100L);
        thirdThread(semaphoreFoo).start();
        Thread.sleep(100L);
        secondThread(semaphoreFoo).start();
    }

    private static void testAtomicIntegerFoo1() throws InterruptedException {
        AtomicIntegerFoo atomicIntegerFoo = new AtomicIntegerFoo();
        firstThread(atomicIntegerFoo).start();
        Thread.sleep(100L);
        secondThread(atomicIntegerFoo).start();
        Thread.sleep(100L);
        thirdThread(atomicIntegerFoo).start();
    }

    private static void testAtomicIntegerFoo2() throws InterruptedException {
        AtomicIntegerFoo atomicIntegerFoo = new AtomicIntegerFoo();
        firstThread(atomicIntegerFoo).start();
        Thread.sleep(100L);
        thirdThread(atomicIntegerFoo).start();
        Thread.sleep(100L);
        secondThread(atomicIntegerFoo).start();
    }

    private static void testCASFoo1() throws InterruptedException {
        CASFoo casFoo = new CASFoo();
        firstThread(casFoo).start();
        Thread.sleep(100L);
        secondThread(casFoo).start();
        Thread.sleep(100L);
        thirdThread(casFoo).start();
    }

    private static void testCASFoo2() throws InterruptedException {
        CASFoo casFoo = new CASFoo();
        firstThread(casFoo).start();
        Thread.sleep(100L);
        thirdThread(casFoo).start();
        Thread.sleep(100L);
        secondThread(casFoo).start();
    }

}
