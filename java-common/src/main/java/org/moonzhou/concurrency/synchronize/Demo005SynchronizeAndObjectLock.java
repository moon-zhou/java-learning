package org.moonzhou.concurrency.synchronize;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * snchronized修饰非静态方法与synchronized(this)互斥，可见，snchronized修饰非静态方法实质锁的是当前对象。
 * @author moon zhou
 */
public class Demo005SynchronizeAndObjectLock {
    public static void main(String[] args) throws Exception {
        // 【注意】当且仅当是同一个SynchronizeAndObjectLock3对象
        Demo005SynchronizeAndObjectLock demo005SynchronizeAndObjectLock = new Demo005SynchronizeAndObjectLock();
        new Thread(() -> {
            demo005SynchronizeAndObjectLock.test1();
        }).start();

        new Thread(() -> {
            demo005SynchronizeAndObjectLock.test2();
        }).start();
    }
    public void test1(){
        synchronized(this) {
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " begin...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + Thread.currentThread().getName() + " end...");
        }

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
