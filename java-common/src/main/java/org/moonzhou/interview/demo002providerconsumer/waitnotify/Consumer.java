package org.moonzhou.interview.demo002providerconsumer.waitnotify;

import java.util.Queue;

public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume() throws InterruptedException {
        synchronized (tasks) {
            // 如果不用while，用if，会出现虚假唤醒，
            // 类似重入的问题，上一次是消费者线程在处理，唤醒后，依然是消费者线程拿到synchronize锁（在容量为0的情况下同一类型不能连续执行两次），造成没有了还在消费
            // 所以使用while而不能使用if
            while (tasks.size() == 0) {
                System.out.println("消费者线程进入等待：" + Thread.currentThread().getName());
                // wait方法会释放monitor
                tasks.wait();
            }
            T ret = tasks.poll();
            System.out.println("消费者在消费：" + Thread.currentThread().getName() + "  数量：" + tasks.size());
            // 调用notify或者notifyAll的时候，必须已经获得对象的monitor，也就是在对象的synchronized块中
            tasks.notifyAll();
            return ret;
        }
    }
}
