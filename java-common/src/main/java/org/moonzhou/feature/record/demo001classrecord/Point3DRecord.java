package org.moonzhou.feature.record.demo001classrecord;

public record Point3DRecord(int x, int y, int z) implements WithXCoordinate {
    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
