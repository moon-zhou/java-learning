package org.moonzhou.javathreadspring.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class AsyncController {
 
    private final AsyncService asyncService;
    private final AsyncServiceWithExecutor asyncServiceWithExecutor;

    public AsyncController(AsyncService asyncService, AsyncServiceWithExecutor asyncServiceWithExecutor) {
        this.asyncService = asyncService;
        this.asyncServiceWithExecutor = asyncServiceWithExecutor;
    }

    @GetMapping("/start-async")
    public String startAsyncTask() {
        asyncService.performAsyncTask(); // 调用异步方法，不会阻塞当前线程
        return "异步任务已启动";
    }

    @GetMapping("/start-async1")
    public String startAsyncTask1() {
        asyncService.performAsyncTask1(); // 调用异步方法，不会阻塞当前线程
        return "异步任务已启动";
    }

    @GetMapping("/start-async2")
    public String startAsyncTask2() {
        asyncService.performAsyncTask2(); // 调用异步方法，不会阻塞当前线程
        return "异步任务已启动";
    }

    @GetMapping("/start-async3")
    public String startAsyncTask3() {
        asyncServiceWithExecutor.performAsyncTaskWithExecutor(); // 调用异步方法，不会阻塞当前线程
        return "异步任务已启动";
    }
}