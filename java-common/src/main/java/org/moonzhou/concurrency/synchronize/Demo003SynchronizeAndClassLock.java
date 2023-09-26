package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * synchronized分别修饰同一个类的静态对象时互斥
 * @author moon zhou
 */
public class Demo003SynchronizeAndClassLock {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            new RunObject1().test1();
        }).start();

        new Thread(() -> {
            new RunObject2().test2();
        }).start();
    }

    static class RunObject1 {
        public static void test1(){
            // 【1】synchronized (StaticLock2.staticLock1) {
            synchronized (StaticLock2.staticLock) {
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


    static class RunObject2 {
        public static void test2() {
            // 【2】synchronized (StaticLock2.staticLock2) {
            synchronized (StaticLock2.staticLock) {
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

    class StaticLock2 {
        public static final Object staticLock = new Object();
    }
}