package org.moonzhou.concurrency.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 不同方法，synchronized是可重入的
 * 重入是值获取锁后，递归调用或者调用另一加锁方法时，直接运行而不需要重新获取锁
 * @author moon zhou
 */
public class Demo013SynchronizeAndReentrant {
    public static void main(String[] args) throws Exception {
        Demo013SynchronizeAndReentrant synchronizeAndReentrant = new Demo013SynchronizeAndReentrant();
        synchronizeAndReentrant.test1();
    }

    public synchronized void test1(){
        try {
            System.out.println("test1 method start...");
            test2();
            TimeUnit.SECONDS.sleep(3);
            System.out.println("test1 method end...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void test2(){
        try {
            System.out.println("test2 method start...");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("test2 method end...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
