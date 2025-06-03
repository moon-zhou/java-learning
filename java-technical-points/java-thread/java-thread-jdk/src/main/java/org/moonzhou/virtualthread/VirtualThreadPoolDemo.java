package org.moonzhou.virtualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class VirtualThreadPoolDemo {
    public static void main(String[] args) {
        // 使用虚拟线程池（每个任务一个虚拟线程）
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " executed by: " + Thread.currentThread());
                });
            }
        } // 自动关闭线程池（try-with-resources）
    }
}