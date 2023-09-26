package org.moonzhou.concurrency.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * main线程中断Thread-0后，Thread-0并不会释放锁并醒过来。但是，ReentrantLock的tryLock或lockInterruptibly是可以被中断的。
 * @author moon zhou
 */
public class Demo009DeadLockCannotInterruptDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " get lock1");
                    try {
                        Thread.sleep(1000);
                        synchronized (lock2) {
                            System.out.println(Thread.currentThread().getName() + " get lock2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " get lock2");
                    try {
                        Thread.sleep(1000);
                        synchronized (lock1) {
                            System.out.println(Thread.currentThread().getName() + " get lock1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("main thread begin to interrupt " + threadA.getName() + " and " + threadA.getName() + " will release lock1...");
        threadA.interrupt();
        System.out.println("main thread end to interrupt");
    }
}
