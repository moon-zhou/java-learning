package org.moonzhou.java21feature.sequencedcollection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/25 14:54
 */
public class Demo001List {
    public static void main(String[] args) {
        test1();

        System.out.println();

        test2();
    }

    private static void test1() {
        List<Integer> integerList = List.of(1,2,3);
        integerList.forEach(System.out::println);

        System.out.println("----------------------");
        // 翻转列表
        List<Integer> reversed = integerList.reversed();
        reversed.forEach(System.out::println);

        System.out.println("----------------------");
        // 获取第一个元素
        Integer first = integerList.getFirst();
        System.out.println(first);
    }

    private static void test2() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.forEach(System.out::println);

        System.out.println("----------------------");
        list.removeLast();
        list.forEach(System.out::println);
    }
}
