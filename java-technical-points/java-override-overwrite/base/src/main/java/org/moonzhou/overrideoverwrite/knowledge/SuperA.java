package org.moonzhou.overrideoverwrite.knowledge;

/**
 * @author moon zhou
 * @description
 * @email
 * @date 2025/6/29 22:21
 **/
public class SuperA {
    public Object test(String value) {
        System.out.printf("superA.test('%s'): Object\n", value);
        return value;
    }
}
