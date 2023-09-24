package org.moonzhou.concurrency.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author moon zhou
 * @version 1.0
 * @description: 测试时方法单独运行
 * @date 2023/9/24 11:13
 */
public class Demo003MoreParkUnpark {
    public static void main(String[] args) throws InterruptedException {
        continuousParkUnpark();
        // alternatingParkUnpark();
    }

    private static void continuousParkUnpark() {
        System.out.println("begin first unpark");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("end first unpark");

        System.out.println("begin second unpark");
        LockSupport.unpark(Thread.currentThread()); // 1次给两张许可证  后面调用两次park
        System.out.println("end second unpark");

        System.out.println("begin first park");
        LockSupport.park();
        System.out.println("end first park");

        System.out.println("begin second park");
        LockSupport.park(); // 此处阻塞，连续unpack多次，只能有一次许可
        System.out.println("end second park");
    }

    /**
     * unpark->park 不阻塞
     */
    private static void alternatingParkUnpark() {
        System.out.println("begin first unpark");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("end first unpark");
        System.out.println("begin first park");
        LockSupport.park();
        System.out.println("end first park");

        System.out.println("begin second unpark");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("end second unpark");
        System.out.println("begin second park");
        LockSupport.park();
        System.out.println("end second park");
    }
}
