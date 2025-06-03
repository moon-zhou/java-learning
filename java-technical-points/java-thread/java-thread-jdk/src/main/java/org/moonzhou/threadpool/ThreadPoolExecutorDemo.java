package org.moonzhou.threadpool;

import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.*;

public class ThreadPoolExecutorDemo {
    
    public interface Task {
        void run() throws Exception;
    }

    public static class ThreadPool {
        private final ExecutorService executorService;
        private final int corePoolSize;
        private final int maxPoolSize;
        private final long keepAliveTime;

        public ThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit) {
            this.corePoolSize = corePoolSize;
            this.maxPoolSize = maxPoolSize;
            this.keepAliveTime = keepAliveTime;
            BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
            ThreadFactory threadFactory = Executors.defaultThreadFactory();
            
            this.executorService = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory
            );
        }

        public void executeTask(Task task) {
            executorService.submit(() -> {
                try {
                    task.run();
                } catch (Exception e) {
                    System.err.println("Task execution failed: " + e.getMessage());
                }
            });
        }

        public void shutdown() {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(1, SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public void executeTaskWithTimeout(Task task, long timeout, TimeUnit unit) {
            executorService.submit(() -> {
                try {
                    task.run();
                } catch (TimeoutException e) {
                    System.err.println("Task execution timed out");
                } catch (Exception e) {
                    System.err.println("Task execution failed: " + e.getMessage());
                }
            });
        }
    }

    // public static void main(String[] args) {
    //     ThreadPool threadPool = new ThreadPool(5, 10, 30, SECONDS);
    //
    //     Task task = () -> {
    //         System.out.println("Task executed by thread: " + Thread.currentThread().getName());
    //         Thread.sleep(1000);
    //         System.out.println("Task completed at: " + System.currentTimeMillis());
    //     };
    //
    //     threadPool.executeTask(task);
    //     threadPool.executeTask(task);
    //     threadPool.executeTask(task);
    //
    //     threadPool.shutdown();
    // }
}
