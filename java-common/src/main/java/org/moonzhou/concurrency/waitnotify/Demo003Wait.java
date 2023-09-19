package org.moonzhou.concurrency.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/19 22:21
 */
public class Demo003Wait {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        // 创建线程并执行
        new Thread(() -> {
            System.out.println("线程1：开始执行");
            synchronized (lock) {
                try {
                    System.out.println("线程1：进入等待");
                    lock.wait(3000);
                    System.out.println("线程1：继续执行");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程1：执行完成");
            }
        }).start();
    }


}
