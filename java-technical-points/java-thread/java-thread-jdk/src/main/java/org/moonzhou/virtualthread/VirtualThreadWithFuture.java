package org.moonzhou.virtualthread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

class VirtualThreadWithFuture {
    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
            System.out.println("Async task in virtual thread: " + Thread.currentThread());
        }, Executors.newVirtualThreadPerTaskExecutor()).join();
    }
}