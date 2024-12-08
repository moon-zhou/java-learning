package org.moonzhou.java21feature.virtualthread;

import java.lang.Thread;

public class VirtualThreadExample001 {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个虚拟线程
        Thread thread = Thread.startVirtualThread(() -> {
            System.out.println("虚拟线程执行开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("虚拟线程执行结束");
        });

        // 等待虚拟线程完成
        thread.join();
        System.out.println("主线程执行完成");
    }
}
