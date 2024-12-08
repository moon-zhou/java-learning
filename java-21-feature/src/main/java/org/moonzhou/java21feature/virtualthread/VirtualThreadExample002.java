package org.moonzhou.java21feature.virtualthread;

import java.util.concurrent.CountDownLatch;

public class VirtualThreadExample002 {

    private static final CountDownLatch cd = new CountDownLatch(1);

    public static void printNumbers() {
        System.out.println("虚拟线程开始执行");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 每打印一个数字暂停1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cd.countDown();
        System.out.println("虚拟线程执行完毕");
    }

    public static void main(String[] args) {

        // 使用Thread.ofVirtual().start()方法启动虚拟线程
        Thread.ofVirtual().start(VirtualThreadExample002::printNumbers);

        try {
            System.out.println("主线程等待，虚拟线程执行");
            cd.await(); // 确保主线程等待虚拟线程完成
            System.out.println("主线程执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}