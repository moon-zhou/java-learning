package org.moonzhou.concurrency.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author moon zhou
 * @version 1.0
 * @description: 测试时方法单独运行
 * @date 2023/9/24 11:13
 */
public class Demo001Park {
    public static void main(String[] args) {
        // park();
        // unpark();
    }

    private static void park() {
        System.out.println("begin park");
        // 线程阻塞
        LockSupport.park();
        System.out.println("end park");
    }

    private static void unpark() {
        System.out.println("begin unpark");
        // 不阻塞
        LockSupport.unpark(Thread.currentThread());
        System.out.println("end unpark");
    }
}
