package org.moonzhou.threadpool;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class ScheduledThreadPoolTest {
    @Test
    void testScheduledTask() throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        CountDownLatch latch = new CountDownLatch(2);

        // 延迟 100ms 后执行
        scheduler.schedule(latch::countDown, 100, TimeUnit.MILLISECONDS);

        // 周期性执行（每 50ms 一次）
        scheduler.scheduleAtFixedRate(latch::countDown, 0, 50, TimeUnit.MILLISECONDS);

        assertTrue(latch.await(300, TimeUnit.MILLISECONDS));
        scheduler.shutdown();
    }
}