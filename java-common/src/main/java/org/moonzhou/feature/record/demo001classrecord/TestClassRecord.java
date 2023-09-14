package org.moonzhou.feature.record.demo001classrecord;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/14 09:48
 */
public class TestClassRecord {
    public static void main(String[] args) {
        testRecordSimpleUsing();

        System.out.println("---------");
        testRecordExtendConstruct();

        System.out.println("---------");
        testInstanceMethod();

        System.out.println("---------");
        testImplementMethod();
    }

    private static void testRecordSimpleUsing() {
        PointRecord p = new PointRecord(3, 4);
        int x = p.x();
        int y = p.y();
        System.out.println(x + "\t" + y);

        PointRecord p2 = new PointRecord(3, 4);
        PointRecord p3 = new PointRecord(7, 5);
        System.out.println(p2.equals(p)); // 输出 true
        System.out.println(p2.equals(p3)); // 输出 false
    }

    private static void testRecordExtendConstruct() {
        PointRecord defaultPoint = new PointRecord();
        System.out.println(defaultPoint.x() + "\t" + defaultPoint.y() + "\t" + PointRecord.getCount());

        PointRecord fixedDifference = new PointRecord(0);
        System.out.println(fixedDifference.x() + "\t" + fixedDifference.y());
    }

    private static void testInstanceMethod() {
        PointRecord from = new PointRecord(0, 0);
        PointRecord to = new PointRecord(3, 4);
        double distance = from.distanceTo(to);
        System.out.println(distance);
    }

    private static void testImplementMethod() {
        PointRecord point = new PointRecord(3, 3);
        System.out.println(point.x());
        point.print();
    }
}
