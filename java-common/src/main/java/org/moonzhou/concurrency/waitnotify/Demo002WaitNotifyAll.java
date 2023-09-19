package org.moonzhou.concurrency.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/19 21:03
 */
public class Demo002WaitNotifyAll {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程1等待执行");
                    lock.wait();
                    System.out.println("线程1继续执行");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程1执行完成");
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程2等待执行");
                    lock.wait();
                    System.out.println("线程2继续执行");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程2执行完成");
        });

        Thread thread3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程3等待执行");
                    lock.wait();
                    System.out.println("线程3继续执行");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程3执行完成");
        });
        thread1.start();
        thread2.start();
        thread3.start();

        Thread thread4 = new Thread(() -> {
            synchronized (lock) {
                // 使用一次notify只能唤醒一个线程；
                // 使用一次notifyAll可唤醒所有的线程
                // lock.notify();
                lock.notifyAll();
                System.out.println("线程4去唤醒wait的线程");
            }

        });
        thread4.start();
    }
}
