package org.moonzhou.thread.demo002;

import org.junit.jupiter.api.Test;
import org.moonzhou.thread.demo002.MyRunnable;

import static org.junit.jupiter.api.Assertions.*;

class MyRunnableTest {
    @Test
    public void testThreadExecution() {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        // 由于线程是异步执行的，这里简单等待一段时间，确保线程有机会执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 这里的断言只是示例，因为线程执行的结果是不确定的，很难做有意义的断言
        // 可以根据实际需求来判断线程是否正常启动等
        assertTrue(thread1.getState() != Thread.State.NEW);
        assertTrue(thread2.getState() != Thread.State.NEW);
    }
}