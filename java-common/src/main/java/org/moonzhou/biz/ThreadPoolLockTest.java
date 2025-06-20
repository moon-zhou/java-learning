package org.moonzhou.biz;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolLockTest {
    public static ThreadPoolExecutor handleExecutor = new ThreadPoolExecutor(1, 1,
            5L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> taskA = new Callable<String>() {
            @Override
            public String call() {
                try {
                    System.out.println("taskA run");

                    Future<String> taskB = handleExecutor.submit(new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            System.out.println("taskB run");
                            return "taskB";
                        }
                    });
                    System.out.println("taskB submit, and block to get result");

                    return taskB.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "taskA";
            }
        };

        Future<?> submit = handleExecutor.submit(taskA);
        System.out.println("taskA submit, and block to get result");
        submit.get();
        System.out.println("finish");
    }
}