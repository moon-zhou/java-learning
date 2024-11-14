package org.moonzhou.concurrency.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程，每个线程执行一次
 * 类似秒杀，每个请求一个机会
 * @author moon zhou
 */
@Slf4j
public class ThreadReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest t = new ReentrantLockTest();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();

        while (true) {
            Thread[] threads = new Thread[Thread.activeCount()];
            Thread.enumerate(threads);
            for (Thread thread : threads) {
                log.info("thread = {}-{}", thread.getName(), thread.getState());
            }
            Thread.sleep(2000);
        }
    }
}

@Slf4j
class ReentrantLockTest implements Runnable {
    ReentrantLock r = new ReentrantLock();
    int t = 2;

    @Override
    public void run() {
        log.info("Thread.currentThread().getName() = {} 在循环外准备开始循环", Thread.currentThread().getName());

        while (true) {

            log.info("Thread.currentThread().getName() = {} 准备动手拿锁", Thread.currentThread().getName());
            r.lock();
            log.info("Thread.currentThread().getName() = {} 拿到了锁", Thread.currentThread().getName());
            if (t > 0) {
                log.info("Thread.currentThread().getName() = {} 在执行 {}", Thread.currentThread().getName(), t);
                t -= 1;
            }

            log.info("Thread.currentThread().getName() = {} 解锁,退出循环", Thread.currentThread().getName());
            r.unlock();
            break;
        }
        log.info("Thread.currentThread().getName() = {} 执行完毕", Thread.currentThread().getName());
    }
}
