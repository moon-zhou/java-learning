package org.moonzhou.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author moon zhou
 * @version 1.0
 * @description: condition使用示例：
 * 1、condition的使用必须要配合锁使用，调用方法时必须要获取锁
 * 2、condition的创建依赖于Lock lock.newCondition()；
 * @date 2023/9/19 23:18
 */
public class Demo004LockConditionAwait {
    /**
     * 创建锁
     */
    private static final Lock lock = new ReentrantLock();

    /**
     * 创建条件
     */
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        // 创建线程并执行
        new Thread(() -> {
            try {
                System.out.println("线程1：开始执行");
                lock.lock();

                System.out.println("线程1：进入等待");
                condition.await(6, TimeUnit.SECONDS);

                System.out.println("线程1：继续执行");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            System.out.println("线程1：执行完成");
        }).start();
    }

}
