package org.moonzhou.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
public class Demo001LockCondition {
    /**
     * 创建锁
     */
    private static final Lock lock = new ReentrantLock();

    /**
     * 创建条件
     */
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Demo001LockCondition useCase = new Demo001LockCondition();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 获取锁进行等待
        executorService.execute(useCase::conditionWait);
        // 获取锁进行唤起读锁
        executorService.execute(useCase::conditionSignal);
    }

    /**
     * 等待线程
     */
    public void conditionWait() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到锁了");
            System.out.println(Thread.currentThread().getName() + "等待信号");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "拿到信号");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 唤起线程
     */
    public void conditionSignal() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到锁了");
            // 睡眠5s 线程1启动
            Thread.sleep(5000);
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "发出信号");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

}
