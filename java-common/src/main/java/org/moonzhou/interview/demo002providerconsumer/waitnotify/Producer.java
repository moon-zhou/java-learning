package org.moonzhou.interview.demo002providerconsumer.waitnotify;

import java.util.Queue;

public class Producer<T> {

    private Queue<T> tasks;

    private int maxTaskCount = 0;

    public Producer(Queue<T> tasks, int maxTaskCount) {
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }

    public void produce(T task) throws InterruptedException {
        synchronized (tasks) {
            // 如果不用while，用if，会出现虚假唤醒，
            // 类似重入的问题，上一次是生产者线程在处理，唤醒后，依然是生产者线程拿到synchronize锁（在容量满的情况下同一类型不能连续执行两次），造成生产大于容量
            // 所以使用while而不能使用if
            while (tasks.size() >= maxTaskCount) {
                System.out.println("生产者线程进入等待：" + Thread.currentThread().getName());
                // wait方法会释放monitor
                tasks.wait();
            }
            tasks.add(task);
            System.out.println("生产者在生产：" + Thread.currentThread().getName() + "  数量：" + tasks.size());
            // 调用notify或者notifyAll的时候，必须已经获得对象的monitor，也就是在对象的synchronized块中
            tasks.notifyAll();
        }
    }
}

