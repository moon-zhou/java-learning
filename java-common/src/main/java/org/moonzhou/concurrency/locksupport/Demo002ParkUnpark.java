package org.moonzhou.concurrency.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author moon zhou
 * @version 1.0
 * @description: 测试时方法单独运行
 *
 * @date 2023/9/24 11:13
 */
public class Demo002ParkUnpark {
    public static void main(String[] args) throws InterruptedException {
        // parkUnpark();

        unparkPark();
    }

    /**
     * park阻塞->unpark给许可证->解除阻塞
     * 注意park/unpark操作的目标线程，得是相同的线程
     * @throws InterruptedException
     */
    private static void parkUnpark() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park");
            LockSupport.park();
            System.out.println("child thread unpark");
        });
        thread.start();

        TimeUnit.SECONDS.sleep(3);

        // 调用 unpark方法让 thread线程持有许可证，然后park方法返回
        System.out.println("main/other thread unpark the park thread...");
        LockSupport.unpark(thread);
    }

    /**
     * unpark给许可证->park->立即返回
     * 注意park/unpark操作的目标线程，得是相同的线程
     */
    private static void unparkPark() {
        Thread thread = new Thread(() -> {
            try {
                // 让子线程睡眠3s 保证主线程有机会给许可证
                System.out.println("children thread wait...");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("child thread begin park");
            LockSupport.park();
            System.out.println("child thread unpark");
        });

        thread.start();

        System.out.println("main/other thread unpark first...");
        LockSupport.unpark(thread);
    }
}
