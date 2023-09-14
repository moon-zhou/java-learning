package org.moonzhou.feature.record.demo001classrecord;

public sealed interface WithXCoordinate permits PointRecord, Point3DRecord {
    /**
     * x变量对应的方法，已经包含了该方法
     *
     * @return
     */
    int x();

    /**
     * 需要显示的实现
     */
    void print();
}
