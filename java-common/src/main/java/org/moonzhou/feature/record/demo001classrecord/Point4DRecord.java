package org.moonzhou.feature.record.demo001classrecord;

/**
 * WithXCoordinate 中permits限制了接口可以被实现的record，此record不在允许之列，硬写编译报错
 * @param x
 * @param y
 * @param z
 * @param t
 */
// public record Point4DRecord(int x, int y, int z) implements WithXCoordinate {
public record Point4DRecord(int x, int y, int z, int t) {

}
