package org.moonzhou.overrideoverwrite.knowledge;

/**
 * @author moon zhou
 * @description
 * @email
 * @date 2025/6/29 22:28
 **/
public class A2 extends SuperA {
    public void test() {
        System.out.println("A1.test()");
    }

    public void test(Object value) {
        System.out.printf("A1.test(%s)\n", value);
    }

    /**
     * 重写父类方法
     * 桥接，合成 bridge synthetic
     * @param value
     * @return
     */
    @Override
    public String test(String value) {
        System.out.printf("superA.test('%s'): String\n", value);
        return value;
    }
}
