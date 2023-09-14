package org.moonzhou.feature.record.demo002define;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/14 22:18
 */
public class TestRecordDefine {
    public static void main(String[] args) {
        testRecord();

        System.out.println("---------");
        testClassMember();

        System.out.println("---------");
        testLocalVariable();

        System.out.println("---------");
        testInnerClassMember();
    }

    private static void testRecord() {
        UserRecord user = new UserRecord(1, "moon zhou", 18);
        System.out.println("user record: " + user.toString());
    }

    private static void testClassMember() {
        RecordClassMember.UserMemberRecord user = new RecordClassMember.UserMemberRecord(1, "moon zhou", 18);
        System.out.println("user class member record: " + user.toString());
    }

    private static void testLocalVariable() {
        RecordLocalVariable recordLocalVariable = new RecordLocalVariable();
        recordLocalVariable.testLocalVariable();
    }

    private static void testInnerClassMember() {
        RecordOuterClass.RecordInnerClass.UserInnerClassRecord user = new RecordOuterClass.RecordInnerClass.UserInnerClassRecord(1, "moon zhou", 18);
        System.out.println("user inner class member record: " + user.toString());
    }
}
