package org.moonzhou.concurrency.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 此示例不是重入示例，仅仅是同一实例多次调用同一加锁方法，需要获取锁之后才能运行
 *
 * @author moon zhou
 */
public class Demo012SynchronizeAndReentrant {
    public static void main(String[] args) throws Exception {
        Demo012SynchronizeAndReentrant synchronizeAndReentrant = new Demo012SynchronizeAndReentrant();
        synchronizeAndReentrant.test();
        synchronizeAndReentrant.test();
        synchronizeAndReentrant.test();
    }

    public synchronized void test() {
        try {
            System.out.println("test method start...");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("test method end...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
