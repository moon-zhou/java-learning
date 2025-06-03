package org.moonzhou.threadpool;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class CachedThreadPoolTest {
    @Test
    void testDynamicThreadCreation() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(10);

        // 提交 10 个任务
        for (int i = 0; i < 10; i++) {
            executor.execute(latch::countDown);
        }

        assertTrue(latch.await(1, TimeUnit.SECONDS));
        executor.shutdown();
    }
}