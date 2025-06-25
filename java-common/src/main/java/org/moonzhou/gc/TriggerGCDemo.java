package org.moonzhou.gc;

/**
 *
 * -verbose:gc 控制台打印 GC 情况
 * -Xms20M 设置最小堆内存为 20MB
 * -Xmx20M 设置最大堆内存为 20MB
 * -Xmn10M 设置新生代容量为 10MB
 * -XX:+PrintGCDetails 控制台打印 GC 详细情况，并在程序退出时打印 Heap 分配情况；
 * -XX:SurvivorRatio=8 设置 Eden:Survivor = 8:1
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8
 *
 *
 */
public class TriggerGCDemo {
    // 1M
    private static final int BASE_SPACE = 1024 * 1024;
    private byte[] bytes = new byte[BASE_SPACE];
    
    // 重写finalize()方法（仅用于演示，生产环境不推荐使用）
    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象正在被GC回收...");
        super.finalize();
    }

    public static void main(String[] args) {
        // 方法1：使用System.gc()
        System.out.println("触发System.gc()");
        createGarbage(); // 创建可回收对象
        System.gc();    // 建议JVM执行GC
        
        // 方法2：使用Runtime.getRuntime().gc()
        System.out.println("触发Runtime.gc()");
        createGarbage();
        Runtime.getRuntime().gc();

        // 增加延迟以观察GC日志（非必需）
        try {
            Thread.sleep(2000); // 等待GC完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 创建可回收的临时对象
    private static void createGarbage() {
        for (int i = 0; i < 30; i++) {
            new TriggerGCDemo(); // 创建匿名对象（无引用，立即成为垃圾）
        }
    }
}