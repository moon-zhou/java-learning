package org.moonzhou.reference.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2025/7/2 21:27
 **/
public class Demo002 {
    public static void main(String[] args) throws InterruptedException {
        // 创建引用队列
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        // 创建虚引用（必须关联引用队列）
        PhantomReference<String> phantomRef = new PhantomReference<>(
                new String("Phantom"), queue
        );

        // 虚引用无法获取对象
        System.out.println(phantomRef.get()); // 输出: null

        // 手动触发GC
        System.gc();
        Thread.sleep(100); // 等待GC完成

        // 检查引用队列
        if (queue.poll() != null) {
            System.out.println("对象已被回收"); // 输出: 对象已被回收
        }

    }
}
