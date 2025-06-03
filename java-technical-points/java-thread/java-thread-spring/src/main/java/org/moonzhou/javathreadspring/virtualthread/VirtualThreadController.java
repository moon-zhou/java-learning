package org.moonzhou.javathreadspring.virtualthread;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirtualThreadController {

    private final AsyncVirtualThreadService asyncVirtualThreadService;

    public VirtualThreadController(AsyncVirtualThreadService asyncVirtualThreadService) {
        this.asyncVirtualThreadService = asyncVirtualThreadService;
    }

    @GetMapping("/thread")
    public String getThreadType() {
        Thread thread = Thread.currentThread();
        return """
            Thread name: %s
            Is virtual: %s
            Platform thread: %s
            """.formatted(
                thread.getName(),
                thread.isVirtual(),
                thread.isVirtual() ? thread.toString() : "N/A"
            );
    }

    @GetMapping("/async")
    public String startAsyncTask() {
        asyncVirtualThreadService.asyncTask(); // 调用异步方法，不会阻塞当前线程
        return "虚拟线程异步任务已启动";
    }
}