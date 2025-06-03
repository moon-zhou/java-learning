package org.moonzhou.javathreadspring.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncService {

    @Async
    public void performAsyncTask() {
        execute();
    }

    @Async("taskExecutorMoon1")
    public void performAsyncTask1() {
        execute();
    }

    @Async("taskExecutorMoon2")
    public void performAsyncTask2() {
        execute();
    }

    private static void execute() {
        // 这里执行异步任务
        try {
            TimeUnit.MICROSECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("执行异步任务: {}", Thread.currentThread().getName());
    }
}