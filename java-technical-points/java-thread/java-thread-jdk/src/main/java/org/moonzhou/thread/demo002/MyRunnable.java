package org.moonzhou.thread.demo002;

import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable方式创建线程: " + i);

            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}