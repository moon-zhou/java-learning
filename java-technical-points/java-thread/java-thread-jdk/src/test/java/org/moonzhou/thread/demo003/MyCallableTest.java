package org.moonzhou.thread.demo003;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static org.junit.jupiter.api.Assertions.*;

class MyCallableTest {
    @Test
    public void testThreadExecution() throws ExecutionException, InterruptedException {
        // 使用方式
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();

        // 获取结果（阻塞直到完成）
        String result = futureTask.get();
        System.out.println(result);
        assertNotNull(result);
    }
}