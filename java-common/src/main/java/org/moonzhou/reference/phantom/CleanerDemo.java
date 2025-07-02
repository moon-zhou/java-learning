package org.moonzhou.reference.phantom;

import java.lang.ref.Cleaner;

public class CleanerDemo {

    // 创建一个需要清理的资源类
    static class Resource implements Runnable {
        private final String name;

        public Resource(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is being cleaned up.");
        }
    }

    public static void main(String[] args) {
        // 创建 Cleaner 实例
        Cleaner cleaner = Cleaner.create();

        // 创建对象
        String strongRef = new String("abc");

        // 创建资源对象并注册到 Cleaner
        Resource resource = new Resource("Resource-1");
        cleaner.register(strongRef, resource);  // 第一个参数是被监控的对象，第二个参数是清理任务

        // 显式释放资源引用
        strongRef = null;

        // 建议 JVM 进行垃圾回收
        System.gc();

        // 等待一段时间以确保 Cleaner 被触发
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}
