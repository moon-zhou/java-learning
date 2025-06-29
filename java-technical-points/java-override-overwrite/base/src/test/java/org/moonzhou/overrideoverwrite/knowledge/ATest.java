package org.moonzhou.overrideoverwrite.knowledge;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ATest {

    @Test
    void testA1() {
        A1 a = new A1();
        boolean test = a.test("test");
        assertTrue(test);
    }

    @Test
    void testA2() {
        A2 a = new A2();
        String test = a.test("test");
        assertEquals("test", test);

        for (Method method : A2.class.getMethods()) {
            if (Object.class == method.getDeclaringClass()) {
                continue;
            }

            // method.isBridge(), method.isSynthetic()，本身也是去读字节码，里面的元信息就包含了
            System.out.printf("Method: %s, bridge: %b, synthetic: %b\n", method, method.isBridge(), method.isSynthetic());
        }
    }

    @Test
    void testList() {
        List<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};

        System.out.printf("list: %s\n", list);

        // 精确匹配
        list.remove(1);
        // list = [1, 3]
        System.out.printf("list: %s\n", list);

        Integer value = 1;
        list.remove(value);
        // list = [3]
        System.out.printf("list: %s\n", list);
    }
}