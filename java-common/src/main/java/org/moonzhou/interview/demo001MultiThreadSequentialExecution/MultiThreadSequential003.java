package org.moonzhou.interview.demo001MultiThreadSequentialExecution;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 * @version 1.0
 * @description: join
 * @date 2023/9/12 09:12
 */
public class MultiThreadSequential003 {

    public static void main(String[] args) {
        final Thread t1 = new Thread(MultiThreadSequential003::mockBiz, "T1");
        final Thread t2 = new Thread(MultiThreadSequential003::mockBiz, "T2");
        final Thread t3 = new Thread(MultiThreadSequential003::mockBiz, "T3");

        // 创建一个单线程化的线程池，以此保证线程顺序执行.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 执行线程
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        // 关闭线程池
        executor.shutdown();
    }

    private static void mockBiz() {
        try {
            System.out.println("thread start:" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("thread end:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
