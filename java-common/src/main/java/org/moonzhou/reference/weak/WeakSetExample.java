package org.moonzhou.reference.weak;

import java.util.*;

public class WeakSetExample {
    public static void main(String[] args) {
        Set<Object> weakSet = Collections.newSetFromMap(new WeakHashMap<>());
        Object item = new Object();

        weakSet.add(item);
        System.out.println("Before GC: " + weakSet.size()); // 输出1

        item = null;
        System.gc();
        try { 
            Thread.sleep(100); 
        } catch (InterruptedException ignored) {}

        System.out.println("After GC: " + weakSet.size()); // 可能输出0
    } 
}
