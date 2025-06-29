package org.moonzhou.overrideoverwrite.knowledge;

import java.io.Serializable;

/**
 * @author moon zhou
 * @description
 * @email
 * @date 2025/6/29 22:49
 **/
public class C {
    public void test(int value) {

    }

    public void test(Integer value) {

    }

    public void test(Number value) {

    }

    public void test(Object value) {

    }

    void action() {
        // 精确匹配
        Number value = 1;
        test(value);

        // 类型匹配
        // Long(3) <- Number(2) <- Object(1)
        Long longValue = 1L;
        test(longValue);

        // 层次匹配
        // Serializable(2) <- Object(1)
        Serializable s = null;
        test(s);
    }
}
