package org.moonzhou.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/28 16:42
 */
public class Demo001AtomicInteger {
    public static void main(String[] args) {
        AtomicInteger order = new AtomicInteger(0);
        System.out.println(order.getAndIncrement()); // 0
        System.out.println(order); // 1

        AtomicInteger order2 = new AtomicInteger(0);
        System.out.println(order2.incrementAndGet()); // 1
        System.out.println(order2); // 1

        AtomicInteger order3 = new AtomicInteger();
        System.out.println(order3.incrementAndGet()); // 1
        System.out.println(order3); // 1
    }
}
