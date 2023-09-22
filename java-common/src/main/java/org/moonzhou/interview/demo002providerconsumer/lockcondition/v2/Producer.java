package org.moonzhou.interview.demo002providerconsumer.lockcondition.v2;

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
            // 此处不能使用if，因为是全部唤醒，唤醒后只有一个线程是满足条件能够进行生产的，其他线程还需要循环一次判断不满足之后进行再次进行等待（效率不高）
            while (tasks.size() >= maxTaskCount) {
                System.out.println("生产者线程进入等待：" + Thread.currentThread().getName());
                // 已满，无法生产：生产线程在接到信号或被中断之前一直处于等待状态
                producerCondition.await();
            }
            tasks.add(task);
            System.out.println("生产者在生产：" + Thread.currentThread().getName() + "  数量：" + tasks.size());
            // 生产完，通知所有消费者进行消费（所有消费者竞争，获取到锁即可消费，所以消费判断条件必须使用while）
            consumerCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

