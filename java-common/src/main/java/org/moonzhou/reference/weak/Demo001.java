package org.moonzhou.reference.weak;

import java.lang.ref.WeakReference;

/**
 * @author moon zhou
 * @description
 * @email ayimin1989@163.com
 * @date 2025/6/25 23:12
 **/
public class Demo001 {
    public static void main(String[] args) {
        WeakReference<MyObject> weakRef = new WeakReference<>(new MyObject());
        System.out.println("GC前：" + weakRef.get()); // 存在
        System.gc();
        System.out.println("GC后：" + weakRef.get()); // 返回null
    }

    static class MyObject {
        public MyObject() {

        }
    }
}
