package org.moonzhou.reference.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2025/6/25 23:13
 **/
public class Demo001 {
    public static void main(String[] args) {
        ReferenceQueue<MyObject> queue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomRef = new PhantomReference<>(new MyObject(), queue);

        new Thread(() -> {
            while(true) {
                Reference<? extends MyObject> ref = queue.poll();
                if(ref != null) {
                    System.out.println("对象已被回收：" + ref);
                    break;
                }
            }
        }).start();

        System.gc(); // 触发回收后通知队列
    }

    static class MyObject {
        public MyObject() {

        }
    }
}
