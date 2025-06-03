package org.moonzhou.threadpool;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FixedThreadPoolTest {
    @Test
    void testConcurrentExecution() throws InterruptedException {
        final int threadCount = 3;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(5);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(100); // 模拟耗时操作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                latch.countDown();
            });
        }

        assertTrue(latch.await(1, TimeUnit.SECONDS));
        executor.shutdown();
    }
}