package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 类锁和对象锁是相互独立的，互不相斥
 * @author moon zhou
 */
public class Demo008ClassAndObjectLock {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            Demo008ClassAndObjectLock.test1();
        }).start();

        new Thread(() -> {
            new Demo008ClassAndObjectLock().test2();
        }).start();
    }
    public static void test1(){
        synchronized (Demo008ClassAndObjectLock.class) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }
    }

    public void test2(){
        synchronized (this) {
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
