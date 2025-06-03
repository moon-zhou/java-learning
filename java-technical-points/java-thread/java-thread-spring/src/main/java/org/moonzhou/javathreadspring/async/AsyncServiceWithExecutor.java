package org.moonzhou.javathreadspring.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.Executor;

@Slf4j
@Service
public class AsyncServiceWithExecutor {

    private final Executor taskExecutor; // 注入Executor Bean

    public AsyncServiceWithExecutor(Executor taskExecutorMoon2) {
        this.taskExecutor = taskExecutorMoon2;
    }

    public void performAsyncTaskWithExecutor() {
        taskExecutor.execute(() -> { // 使用Lambda表达式传递Runnable任务到线程池中执行
            log.info("执行异步任务: {}", Thread.currentThread().getName()); // 打印当前线程名，以显示异步执行效果
        }); 
    } 
} 