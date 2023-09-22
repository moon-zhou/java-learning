package org.moonzhou.interview.demo002providerconsumer.lockcondition.v1;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer<T> {

    private Queue<T> tasks;

    private int maxTaskCount = 0;

    public Producer(Queue<T> tasks, int maxTaskCount) {
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }

    public void produce(T task, Lock lock, Condition producerCondition, Condition consumerCondition) throws InterruptedException {
        try {
            lock.lock();
            // 此处可以使用if，示例见v3，因为生产和消费唤醒时采用的互相唤醒，唤醒一个线程之后已经满足了可以生产的条件，无需while再次进行判断，
            // 与synchronized公用锁不同，可能会唤醒自己的情况（伪唤醒）
            while (tasks.size() >= maxTaskCount) {
                System.out.println("生产者线程进入等待：" + Thread.currentThread().getName());
                // 已满，无法生产：生产线程在接到信号或被中断之前一直处于等待状态
                producerCondition.await();
            }
            tasks.add(task);
            System.out.println("生产者在生产：" + Thread.currentThread().getName() + "  数量：" + tasks.size());
            // 生产完，通知消费者进行消费（只唤醒一个线程，所以可以用if）
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}

