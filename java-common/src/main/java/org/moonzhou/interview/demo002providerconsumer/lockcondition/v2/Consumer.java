package org.moonzhou.interview.demo002providerconsumer.lockcondition.v2;

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
            // 此处不能使用if，因为是全部唤醒，唤醒后只有一个线程是满足条件能够进行消费的，其他线程还需要循环一次判断不满足之后进行再次进行等待（效率不高）
            while (tasks.size() == 0) {
                System.out.println("消费者线程进入等待：" + Thread.currentThread().getName());
                // 消费线程在接到信号或被中断之前一直处于等待状态
                consumerCondition.await();
            }
            T ret = tasks.poll();
            System.out.println("消费者在消费：" + Thread.currentThread().getName() + "  数量：" + tasks.size());
            // 消费完，通知所有生产者进行生产（所有生产者竞争，获取到锁即可生产，所以生产判断条件必须使用while）
            producerCondition.signalAll();
            return ret;
        } finally {
            lock.unlock();
        }
    }
}
