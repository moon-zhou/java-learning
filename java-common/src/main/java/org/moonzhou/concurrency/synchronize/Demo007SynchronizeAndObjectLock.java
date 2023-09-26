package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 */
public class Demo007SynchronizeAndObjectLock {
    /**
     * 实例对象级别的锁
     * 如果变为static，则升级为类级别的锁
     */
    private Object objectLock = new Object();

    public static void main(String[] args) throws Exception {
        
        Demo007SynchronizeAndObjectLock demo007SynchronizeAndObjectLock = new Demo007SynchronizeAndObjectLock();
        new Thread(() -> {
            demo007SynchronizeAndObjectLock.test1();
        }).start();

        new Thread(() -> {
            demo007SynchronizeAndObjectLock.test2();
        }).start();
    }
    public void test1(){
        synchronized(objectLock) {
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
        synchronized(objectLock) {
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
