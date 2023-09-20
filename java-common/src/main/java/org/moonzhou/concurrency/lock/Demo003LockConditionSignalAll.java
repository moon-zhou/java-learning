package org.moonzhou.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 *
 * 线程1：争抢锁
 * 线程1：抢到锁，开始执行
 * 线程1：进入等待
 * 线程3：争抢锁
 * 线程2：争抢锁
 * 线程3：抢到锁，开始执行
 * 线程3：进入等待
 * 线程2：抢到锁，开始执行
 * 线程2：进入等待
 * 唤醒线程：执行 signal() / signalAll()
 * 唤醒线程：signal() 完成，执行自己的业务
 * 唤醒线程：unlock()
 * 线程1：继续执行
 * 线程1：unlock
 * 线程1：执行完成
 * 线程3：继续执行
 * 线程3：unlock
 * 线程3：执行完成
 * 线程2：继续执行
 * 线程2：unlock
 * 线程2：执行完成
 *
 * @date 2023/9/20 21:55
 */
public class Demo003LockConditionSignalAll {
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
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("线程1：争抢锁");
                lock.lock();
                System.out.println("线程1：抢到锁，开始执行");

                System.out.println("线程1：进入等待");
                condition.await();

                System.out.println("线程1：继续执行");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("线程1：unlock");
                lock.unlock();
            }
            System.out.println("线程1：执行完成");
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("线程2：争抢锁");
                lock.lock();
                System.out.println("线程2：抢到锁，开始执行");

                System.out.println("线程2：进入等待");
                condition.await();

                System.out.println("线程2：继续执行");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("线程2：unlock");
                lock.unlock();
            }
            System.out.println("线程2：执行完成");
        });

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("线程3：争抢锁");
                lock.lock();
                System.out.println("线程3：抢到锁，开始执行");

                System.out.println("线程3：进入等待");
                condition.await();

                System.out.println("线程3：继续执行");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("线程3：unlock");
                lock.unlock();
            }
            System.out.println("线程3：执行完成");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            try {
                lock.lock();
                // 唤醒线程
                System.out.println("唤醒线程：执行 signal() / signalAll()");
                condition.signalAll();
                System.out.println("唤醒线程：signal() 完成，执行自己的业务");
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // 得unlock之后，其他线程才能继续争抢锁，抢到锁继续执行
                System.out.println("唤醒线程：unlock()");
                lock.unlock();
            }
        }).start();
    }
}
