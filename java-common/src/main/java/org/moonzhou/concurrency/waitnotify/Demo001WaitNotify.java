package org.moonzhou.concurrency.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/19 21:03
 */
public class Demo001WaitNotify {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程并执行
        new Thread(() -> {
            System.out.println("线程1：开始执行");
            synchronized (lock) {
                try {
                    System.out.println("线程1：进入等待");
                    lock.wait();
                    System.out.println("线程1：继续执行");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程1：执行完成");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            synchronized (lock) {
                // 唤醒线程
                System.out.println("执行 notify() / notifyAll()");
                // lock.notifyAll();
                lock.notify();
            }
        }).start();
    }
}
