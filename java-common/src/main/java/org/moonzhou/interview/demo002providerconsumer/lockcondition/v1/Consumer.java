package org.moonzhou.interview.demo002providerconsumer.lockcondition.v1;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume(Lock lock, Condition producerCondition, Condition consumerCondition) throws InterruptedException {
        try {
            lock.lock();
            // 此处可以使用if，示例见v3，因为生产和消费唤醒时采用的互相唤醒，唤醒一个线程之后已经满足了可以消费的条件，无需while再次进行判断，
            // 与synchronized公用锁不同，可能会唤醒自己的情况（伪唤醒）
            while (tasks.size() == 0) {
                System.out.println("消费者线程进入等待：" + Thread.currentThread().getName());
                // 无可消费的内容：消费线程在接到信号或被中断之前一直处于等待状态
                consumerCondition.await();
            }
            T ret = tasks.poll();
            System.out.println("消费者在消费：" + Thread.currentThread().getName() + "  数量：" + tasks.size());
            // 消费完，通知生产者进行生产（只唤醒一个线程，所以可以用if）
            producerCondition.signal();
            return ret;
        } finally {
            lock.unlock();
        }
    }
}
