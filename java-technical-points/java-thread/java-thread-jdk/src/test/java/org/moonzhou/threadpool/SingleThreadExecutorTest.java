package org.moonzhou.threadpool;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class SingleThreadExecutorTest {
    @Test
    void testSequentialExecution() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        StringBuilder result = new StringBuilder();
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            int taskId = i;
            executor.execute(() -> {
                result.append(taskId);
                latch.countDown();
            });
        }

        latch.await(1, TimeUnit.SECONDS);
        assertEquals("012", result.toString()); // 验证顺序执行
        executor.shutdown();
    }
}