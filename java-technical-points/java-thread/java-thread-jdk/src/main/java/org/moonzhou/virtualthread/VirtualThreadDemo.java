package org.moonzhou.virtualthread;

class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // 直接创建虚拟线程
        Thread virtualThread = Thread.ofVirtual()
            .name("my-virtual-thread")
            .start(() -> {
                System.out.println("Virtual thread running: " + Thread.currentThread().getName());
            });

        virtualThread.join(); // 等待虚拟线程结束
    }
}