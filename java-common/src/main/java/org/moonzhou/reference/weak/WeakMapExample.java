package org.moonzhou.reference.weak;

import java.util.Map;
import java.util.WeakHashMap; 

public class WeakMapExample {
    public static void main(String[] args) {
        Map<Object, String> map = new WeakHashMap<>();
        Object key = new Object();

        map.put(key, "Some value");

        System.out.println("Before GC: " + map.size()); // 输出1

        key = null; // 移除强引用
        System.gc(); // 提示GC进行回收

        try { 
            Thread.sleep(100); 
        } catch (InterruptedException ignored) {}

        System.out.println("After GC: " + map.size()); // 可能输出0
    } 
}
