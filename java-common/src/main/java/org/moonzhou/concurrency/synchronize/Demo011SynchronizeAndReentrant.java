package org.moonzhou.concurrency.synchronize;

/**
 * 相同方法，synchronized是可重入的
 * 重入是值获取锁后，递归调用或者调用另一加锁方法时，直接运行而不需要重新获取锁
 * @author moon zhou
 */
public class Demo011SynchronizeAndReentrant {
    int i = 1;
    public static void main(String[] args) throws Exception {
        Demo011SynchronizeAndReentrant synchronizeAndReentrant = new Demo011SynchronizeAndReentrant();
        synchronizeAndReentrant.test1();
    }
    public synchronized void test1(){

        System.out.println(" test1 method is called " + i++ + "st time..." );
        while(i < 5) {
            test1();
        }
    }
}
