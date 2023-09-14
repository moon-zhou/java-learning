package org.moonzhou.feature.record.demo002define;

/**
 * 局部变量
 * @author moon zhou
 */
public class RecordLocalVariable {
    public void testLocalVariable() {
        record UserMemberRecord(long id, String name, int age) {}

        UserMemberRecord user = new UserMemberRecord(1, "moon zhou", 18);
        System.out.println(user.toString());
    }
}