package org.moonzhou.javathreadspring.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class InitController {

    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(4);

    /**
     * ab -n 1000 -c 10 http://localhost:8080/method-init1
     * @return
     */
    @GetMapping("/method-init1")
    public String startAsyncTask1() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
        executor.schedule(() -> {
            try {
                log.info("test {}: {}", LocalDateTime.now(), Thread.currentThread().getName());
            } catch (Exception e) {
                log.error("异步线程池异常",e);
            }
        }, 2L, TimeUnit.SECONDS);
        return "异步任务已启动";
    }

    /**
     * ab -n 1000 -c 10 http://localhost:8080/method-init2
     * @return
     */
    @GetMapping("/method-init2")
    public String startAsyncTask2() {
        try (ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4)) {
            executor.schedule(() -> {
                try {
                    log.info("test {}: {}", LocalDateTime.now(), Thread.currentThread().getName());
                } catch (Exception e) {
                    log.error("异步线程池异常", e);
                }
            }, 2L, TimeUnit.SECONDS);
        }
        return "异步任务已启动";
    }

    /**
     * ab -n 1000 -c 10 http://localhost:8080/method-init3
     * @return
     */
    @GetMapping("/method-init3")
    public String startAsyncTask3() {
        scheduledThreadPoolExecutor.schedule(() -> {
            try {
                log.info("test {}: {}", LocalDateTime.now(), Thread.currentThread().getName());
            } catch (Exception e) {
                log.error("异步线程池异常",e);
            }
        }, 2L, TimeUnit.SECONDS);
        return "异步任务已启动";
    }

}