package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程同时执行被synchronized修饰的不同对象的不同（相同）方法，锁未生效，因为两个线程使用的是不同的对象锁。
 * @author moon zhou
 */
public class Demo006SynchronizeAndObjectLock {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            // 这里new 了一个SynchronizeAndObjectLock对象
            new Demo006SynchronizeAndObjectLock().test1();
        }).start();

        new Thread(() -> {
            // 这里new 了另一个SynchronizeAndObjectLock对象
            // new Demo006SynchronizeAndObjectLock().test2();
            new Demo006SynchronizeAndObjectLock().test1();
        }).start();
    }
    public synchronized void test1(){
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
    }

    public synchronized void test2(){
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
    }
}
