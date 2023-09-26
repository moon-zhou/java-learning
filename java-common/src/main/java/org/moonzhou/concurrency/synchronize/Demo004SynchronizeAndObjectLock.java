package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程同时执行被synchronized修饰的相同对象的不同（相同）方法，锁生效，因为两个线程使用的是相同的对象锁
 * @author moon zhou
 */
public class Demo004SynchronizeAndObjectLock {
    public static void main(String[] args) throws Exception {
        // 【注意】当且仅当是同一个SynchronizeAndObjectLock2对象
        Demo004SynchronizeAndObjectLock demo004SynchronizeAndObjectLock = new Demo004SynchronizeAndObjectLock();
        new Thread(() -> {
            demo004SynchronizeAndObjectLock.test1();
        }).start();

        new Thread(() -> {
            demo004SynchronizeAndObjectLock.test2();
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
