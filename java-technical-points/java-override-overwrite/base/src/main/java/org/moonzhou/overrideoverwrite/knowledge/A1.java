package org.moonzhou.overrideoverwrite.knowledge;

/**
 * @author moon zhou
 * @description 方法重载
 * @email
 * @date 2025/6/29 22:01
 **/
public class A1 {
    public void test() {
        System.out.println("A1.test()");
    }

    public void test(Object value) {
        System.out.printf("A1.test(%s)\n", value);
    }

    public boolean test(String value) {
        System.out.printf("A1.test('%s')\n", value);
        return true;
    }
}
