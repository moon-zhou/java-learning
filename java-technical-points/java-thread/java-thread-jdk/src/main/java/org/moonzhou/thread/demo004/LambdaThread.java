package org.moonzhou.thread.demo004;

import java.util.concurrent.*;

/**
 * @author
 * @version 1.0
 * @description:
 * @date 2025/5/25 20:17
 */
public class LambdaThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 简化Runnable
        new Thread(() -> System.out.println("Lambda简化Runnable")).start();

        // 简化Callable
        FutureTask<String> future = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(5);
            return "Lambda简化Callable";
        });
        new Thread(future).start();
        System.out.println("同步阻塞获取结果");
        System.out.println(future.get());
    }
}
