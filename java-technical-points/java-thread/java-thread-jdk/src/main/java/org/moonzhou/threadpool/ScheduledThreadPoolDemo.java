package org.moonzhou.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 延迟执行
        scheduler.schedule(
            () -> System.out.println("Delayed task executed"),
            1, TimeUnit.SECONDS
        );

        // 周期性执行
        scheduler.scheduleAtFixedRate(
            () -> System.out.println("Periodic task executed"),
            0, 2, TimeUnit.SECONDS
        );

        // 关闭（实际应用中需要更复杂的关闭逻辑）
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.shutdown();
    }
}