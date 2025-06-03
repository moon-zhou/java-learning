package org.moonzhou.thread.demo001;

import java.util.concurrent.TimeUnit;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread方式创建线程 " + getName() + " 正在运行: " + i);

            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}