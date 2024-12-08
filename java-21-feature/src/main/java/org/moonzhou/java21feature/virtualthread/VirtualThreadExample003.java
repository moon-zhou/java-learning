package org.moonzhou.java21feature.virtualthread;

/**
 * @author moon zhou
 * @description: 优化 {@link VirtualThreadExample002}
 */
public class VirtualThreadExample003 {

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
        System.out.println("虚拟线程执行完毕");
    }

    public static void main(String[] args) {

        // 使用Thread.ofVirtual().start()方法启动虚拟线程
        Thread thread = Thread.ofVirtual().unstarted(VirtualThreadExample003::printNumbers);

        try {
            System.out.println("主线程等待，虚拟线程执行");
            thread.start();
            thread.join(); // 确保主线程等待虚拟线程完成
            System.out.println("主线程执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}