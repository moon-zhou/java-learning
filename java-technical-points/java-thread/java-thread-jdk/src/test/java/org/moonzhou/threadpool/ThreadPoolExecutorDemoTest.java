package org.moonzhou.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ThreadPoolExecutorDemoTest {
    @Test
    void testThreadPoolExecution() {
        ThreadPoolExecutorDemo.ThreadPool threadPool = new ThreadPoolExecutorDemo.ThreadPool(5, 10, 30, TimeUnit.SECONDS);

        ThreadPoolExecutorDemo.Task task = () -> {
            System.out.println("Task executed by thread: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Task completed at: " + System.currentTimeMillis());
        };

        threadPool.executeTask(task);
        threadPool.executeTask(task);
        threadPool.executeTask(task);

        threadPool.shutdown();
    }

    @Test
    void testTaskExecutionFailure() {
        ThreadPoolExecutorDemo.ThreadPool threadPool = new ThreadPoolExecutorDemo.ThreadPool(5, 10, 30, TimeUnit.SECONDS);

        ThreadPoolExecutorDemo.Task failingTask = () -> {
            throw new RuntimeException("Task failed intentionally");
        };

        threadPool.executeTask(failingTask);
        threadPool.shutdown();
    }

    @Test
    void testTaskTimeout() {
        ThreadPoolExecutorDemo.ThreadPool threadPool = new ThreadPoolExecutorDemo.ThreadPool(5, 10, 30, TimeUnit.SECONDS);

        ThreadPoolExecutorDemo.Task timeoutTask = () -> {
            Thread.sleep(2000);
            System.out.println("Task completed after timeout");
        };

        threadPool.executeTaskWithTimeout(timeoutTask, 1, TimeUnit.SECONDS);
        threadPool.shutdown();
    }
}