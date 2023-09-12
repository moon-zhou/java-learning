package org.moonzhou.interview.demo001MultiThreadSequentialExecution;

import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 * @version 1.0
 * @description: join
 * @date 2023/9/12 09:12
 */
public class MultiThreadSequential001 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new runThread(null));
        Thread t2 = new Thread(new runThread(t1));
        Thread t3 = new Thread(new runThread(t2));
        t1.start();
        t2.start();
        t3.start();
    }

    static class runThread implements Runnable {
        // 上一个线程
        private final Thread beforeThread;

        // 构造赋值
        public runThread(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }

        @Override
        public void run() {
            try {
                // 保证第一个线程执行。
                if (beforeThread != null) {
                    // 执行join()，合并为顺序执行的线程。
                    beforeThread.join();
                    mockBiz();
                } else {
                    mockBiz();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void mockBiz() throws InterruptedException {
            System.out.println("thread start:" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("thread end:" + Thread.currentThread().getName());
        }
    }
}
