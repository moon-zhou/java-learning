package org.moonzhou.jit.demo001expressionhoisting;

import java.util.concurrent.TimeUnit;

/**
 * println 代码影响了编译器的优化。println 方法由于最终会调用 FileOutputStream.writeBytes 这个 native 方法，所以无法被内联优化（inling）。
 * 而未被内敛的方法调用从编译器的角度看是一个“full memory kill”，也就是说 副作用不明 、必须对内存的读写操作做保守处理。
 *
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/12/4 16:25
 */
public class ExpressionHoistingNegative2 {
    volatile static boolean stopRequested = false;
    // final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {

                // 加上一行打印，循环就能退出了！
                //				System.out.println(i++);
                // new ExpressionHoistingNegative2().test();
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(5);
        stopRequested = true;
        System.out.println("done.");
    }

    /* private void test() {

        synchronized (lock) {
            System.out.println(lock);
        }
    } */
}
