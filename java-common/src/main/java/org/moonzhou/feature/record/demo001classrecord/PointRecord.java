package org.moonzhou.feature.record.demo001classrecord;

import java.util.concurrent.atomic.AtomicLong;

/**
 * record 是一个特殊的类，是继承了Record的类，所以record不能再继承别的类，但是可以实现别的接口
 * 因为record本身是final的，因此也不能被别的类继承
 * @param x
 * @param y
 * @author moon zhou
 */
public record PointRecord(int x, int y) implements WithXCoordinate {
    private static final int ZERO = 0;
    private static final AtomicLong COUNT = new AtomicLong(0);

    public PointRecord() {
        // 必须初始化值
        // Non-canonical record constructor must delegate to another constructor
        this(ZERO, ZERO);
        COUNT.incrementAndGet();
    }

    public PointRecord(int v) {
        this(v, v + 3);
    }

    // compile error, 如果要覆盖默认构造函数，则构造函数参数名称必须与原有构造函数的参数变量名一致
    // public PointRecord(int m, int n) {
    //     this.x = m;
    //     this.y = n;
    // }

    /**
     * right way
     * @param x
     * @param y
     */
    public PointRecord(int x, int y) {
        // this.x = x + 1;
        // this.y = y + 1;
        this.x = x;
        this.y = y;
    }

    /**
     * static method
     * 只能通过类名方式调用，不能使用实例名调用，在编译器层面做了控制，编译不通过
     * @return
     */
    public static Long getCount() {
        return COUNT.get();
    }

    /**
     * instance method
     * @param target
     * @return
     */
    public double distanceTo(PointRecord target) {
        int dx = target.x() - this.x();
        int dy = target.y() - this.y();
        return Math.sqrt(dx *dx + dy* dy);
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
