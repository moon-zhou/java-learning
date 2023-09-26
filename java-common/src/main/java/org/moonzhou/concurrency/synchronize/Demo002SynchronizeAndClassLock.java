package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程同时分别执行一个被synchronized修饰static方法，一个有synchnized(该类)代码块的static方法，锁生效，虽然是不同对象，因为两个线程使用的同一个类锁。
 * @author moon zhou
 */
public class Demo002SynchronizeAndClassLock {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            // new了一个ClassLock2对象
            new ClassLock2().test1();
            // ClassLock2.test1();
        }).start();

        new Thread(() -> {
            // new了另一个ClassLock2对象
            new ClassLock2().test2();
            // ClassLock2.test2();
        }).start();
    }

    static class ClassLock2 {
        public synchronized static void test1(){
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }

        public static void test2(){
            // 【注意】synchronized (Demo002SynchronizeAndClassLock.class)不会互斥
            synchronized (ClassLock2.class) {
                System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
            }
        }
    }
}