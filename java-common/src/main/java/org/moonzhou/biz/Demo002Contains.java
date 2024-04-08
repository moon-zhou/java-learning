package org.moonzhou.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/4/7 15:52
 */
public class Demo002Contains {
    public static void main(String[] args) {
        listContain();

        System.out.println();

        setContain();
    }

    private static void listContain() {
        List<Long> list = List.of(1L, 2L, 3L, 333L, 666L, 999L);
        System.out.println(list.contains(1L));
        System.out.println(list.contains(3L));
        System.out.println(list.contains(333L));
        System.out.println(list.contains(999L));
        System.out.println(list.contains(0L));
    }

    private static void setContain() {
        Set<Long> set = Set.of(1L, 2L, 3L, 333L, 666L, 999L);
        System.out.println(set.contains(1L));
        System.out.println(set.contains(3L));
        System.out.println(set.contains(333L));
        System.out.println(set.contains(999L));
        System.out.println(set.contains(0L));
    }
}
