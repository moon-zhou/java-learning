package org.moonzhou.feature.record.demo002define;

/**
 * record为内部类的成员变量
 *
 * @author moon zhou
 */
public class RecordOuterClass {

    static class RecordInnerClass {
        record UserInnerClassRecord(long id, String name, int age) {
        }
    }
}