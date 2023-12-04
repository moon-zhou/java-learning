package org.moonzhou.jit.demo001expressionhoisting;

import java.util.concurrent.TimeUnit;

/**
 * 配置VM options: -Xint(禁用JIT)，可退出死循环
 * <p>
 * JIT 做了表达式提升（不是JMM）
 *
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/12/4 16:25
 */
public class ExpressionHoistingActive {
    static boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.MICROSECONDS.sleep(10);
        stopRequested = true;
    }
}
