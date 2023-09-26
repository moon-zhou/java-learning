package org.moonzhou.concurrency.synchronize;

/**
 * 不同方法，synchronized是可重入的
 * @author moon zhou
 */
public class Demo010SynchronizeAndReentrant {
    public static void main(String[] args) throws Exception {
        Demo010SynchronizeAndReentrant demo010SynchronizeAndReentrant = new Demo010SynchronizeAndReentrant();
        demo010SynchronizeAndReentrant.test1();
    }
    public synchronized void test1(){
        System.out.println(" test1 method is called...");
        test2();
    }

    public synchronized void test2(){
        System.out.println(" test2 method is called...");
    }
}
