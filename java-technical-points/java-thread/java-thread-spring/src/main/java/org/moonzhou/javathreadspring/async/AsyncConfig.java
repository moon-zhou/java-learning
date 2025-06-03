package org.moonzhou.javathreadspring.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@EnableAsync
@Configuration
public class AsyncConfig {
    @Bean("taskExecutorMoon1")
    public Executor getTaskExecutorMoon1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4); // 设置核心线程数
        executor.setMaxPoolSize(8); // 设置最大线程数
        executor.setQueueCapacity(20); // 设置队列容量
        executor.setThreadNamePrefix("moon-1-");
        executor.initialize(); // 初始化线程池
        return executor;
    }

    @Bean("taskExecutorMoon2")
    public Executor getTaskExecutorMoon2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4); // 设置核心线程数
        executor.setMaxPoolSize(8); // 设置最大线程数
        executor.setQueueCapacity(500); // 设置队列容量
        executor.setThreadNamePrefix("moon-2-");
        executor.initialize(); // 初始化线程池
        return executor;
    }

    @Bean("virtualThread")
    public Executor getVirtualThread() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
}