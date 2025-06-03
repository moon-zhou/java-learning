package org.moonzhou.virtualthread;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class VirtualThreadTest {

    @Test
    void testVirtualThreadExecution() throws InterruptedException {
        // 使用虚拟线程执行任务
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                return "Task executed by: " + Thread.currentThread();
            }, executor);

            String result = future.join();
            System.out.println(result);
            assertTrue(result.contains("VirtualThread")); // 验证是否由虚拟线程执行
        }
    }

    @Test
    void testConcurrentVirtualThreads() throws InterruptedException {
        final int taskCount = 100;
        CountDownLatch latch = new CountDownLatch(taskCount);
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < taskCount; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(10); // 模拟短暂阻塞
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    latch.countDown();
                });
            }
            assertTrue(latch.await(2, TimeUnit.SECONDS)); // 验证所有任务完成
        }
    }

    @Test
    void testVirtualThreadCarrierReuse() throws InterruptedException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            String[] threadNames = new String[2];
            CountDownLatch latch = new CountDownLatch(2);

            executor.submit(() -> {
                threadNames[0] = Thread.currentThread().toString();
                latch.countDown();
            });
            executor.submit(() -> {
                threadNames[1] = Thread.currentThread().toString();
                latch.countDown();
            });

            latch.await(1, TimeUnit.SECONDS);
            // 两个虚拟线程可能共享同一个载体线程（但虚拟线程本身不同）
            System.out.println("Thread 1: " + threadNames[0]);
            System.out.println("Thread 2: " + threadNames[1]);
            assertNotEquals(threadNames[0], threadNames[1]); // 虚拟线程名称不同
        }
    }
}