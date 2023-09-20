package org.moonzhou.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/20 21:55
 */
public class Demo002LockCondition {
    /**
     * 创建锁
     */
    private static final Lock lock = new ReentrantLock();

    /**
     * 创建条件
     */
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程并执行
        new Thread(() -> {
            try {
                System.out.println("线程1：开始执行");
                lock.lock();

                System.out.println("线程1：进入等待");
                condition.await();

                System.out.println("线程1：继续执行");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            System.out.println("线程1：执行完成");
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            try {
                lock.lock();
                // 唤醒线程
                System.out.println("线程2：执行 signal() / signalAll()");
                condition.signal();
                System.out.println("线程2：signal() 完成，执行自己的业务");
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // 得unlock之后，线程1才能或得锁继续执行
                System.out.println("线程2：unlock()");
                lock.unlock();
            }
        }).start();
    }
}
