package org.moonzhou.interview.demo002providerconsumer.lockcondition.v3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest {

    private static final Lock lock = new ReentrantLock();

    private static final Condition producerCondition = lock.newCondition();
    private static final Condition consumerCondition = lock.newCondition();

    public static void main(String[] args) {
        Queue<String> urls = new LinkedList<>();

        Consumer<String> consumer = new Consumer<>(urls);
        Producer<String> producer = new Producer<>(urls, 1024);
        for (int i = 0; i < 100; i++) {
            Thread consumerThread = new Thread(() -> {
                while (true) {
                    try {
                        String url = consumer.consume(lock, producerCondition, consumerCondition);
                        processURL(url);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "消费者-" + i);
            consumerThread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread producerThread = new Thread(() -> {
                while (true) {
                    try {
                        String url = produceURL();
                        producer.produce(url, lock, producerCondition, consumerCondition);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "生产者-" + i);
            producerThread.start();
        }
    }

    private static String produceURL() {
        StringBuilder ret = new StringBuilder();
        ret.append("www.");
        for (int i = 0; i < 6; i++) {
            int rand = ((int) (Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        ret.append(".com");
        return ret.toString();
    }

    private static void processURL(String url) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " 开始处理：" + url);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println(Thread.currentThread().getName() + " 处理完成：" + url);
    }

}

