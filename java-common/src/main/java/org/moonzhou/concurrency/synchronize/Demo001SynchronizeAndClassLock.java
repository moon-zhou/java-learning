package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程分别同时执行同一个类产生的不同对象的两个不同 synchronized static方法，类锁生效，虽然是不同对象，因为两个线程使用的是同一个类锁。
 * @author moon zhou
 */
public class Demo001SynchronizeAndClassLock {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            // new了一个ClassLock对象
            new ClassLock().test1();
        }).start();

        new Thread(() -> {
            // new了另一个ClassLock对象
            new ClassLock().test2();
        }).start();
    }

    static class ClassLock {
        public synchronized static void test1() {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }

        /**
         * 【注意】public static void test2(){ 不会互斥，因为此时test2没有使用类锁。
         */
        public synchronized static void test2() {
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