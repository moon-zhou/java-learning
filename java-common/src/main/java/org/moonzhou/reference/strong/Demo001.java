package org.moonzhou.reference.strong;

import java.util.concurrent.TimeUnit;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2025/6/25 14:44
 **/
public class Demo001 {
    public static void main(String[] args) {
        MyObject obj = new MyObject(); // 强引用
        System.out.println("未置空，Gc前：" + obj);

        System.gc(); // 触发GC
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("未置空，GC后对象状态：" + obj); // 对象依然存在

        obj = null; // 断开强引用
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        System.out.println("置空后，GC结果：" + obj); // 对象被回收
    }

    static class MyObject {
        public MyObject() {

        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("对象被回收了, finalize()");
        }
    }
}
