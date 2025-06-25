package org.moonzhou.reference.strong;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2025/6/25 14:44
 **/
public class Demo001 {
    public static void main(String[] args) {
        MyObject obj = new MyObject(); // 强引用
        System.gc(); // 触发GC
        System.out.println("GC后对象状态：" + obj); // 对象依然存在

        obj = null; // 断开强引用
        System.gc();
        System.out.println("置空后GC结果：" + obj); // 对象被回收
    }

    static class MyObject {
        public MyObject() {

        }
    }
}
