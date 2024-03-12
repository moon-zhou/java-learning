package org.moonzhou.biz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/19 15:50
 */
public class Demo001ToSplitString {
    private static final String SPLIT_CHAR = ",";

    /*
     * List.of() 是 Java 9 引入的一个新方法，它属于 Java 集合框架的一部分，用于创建不可变（immutable）的列表对象。它接受可变数量的参数，返回一个包含这些参数的不可变列表。 线程安全，泛型支持。
     * Arrays.asList() 基于数组的，它将现有数组包装为一个列表。 内部的：java.util.Arrays.ArrayList
     */
    // private static final List<String> DATA = Arrays.asList("moon1", "moon2", "moon3");
    private static final List<String> DATA = List.of("moon1");

    public static void main(String[] args) {
        manualSplicing();

        System.out.println();

        stringJoin();

        System.out.println();

        lambdaJoin();
    }

    private static void manualSplicing() {
        StringBuilder builder = new StringBuilder();
        for (String s : DATA) {
            builder.append(s);
            builder.append(SPLIT_CHAR);
        }
        String substring = builder.substring(0, builder.length() - 1);

        System.out.println("append 转化后的字符串 : " + substring);
    }

    private static void stringJoin() {
        String str = String.join(",", DATA); // StringUtils.join(list, ",");

        System.out.println("String.join() 转化后的字符串 : " + str);
    }

    private static void lambdaJoin() {
        // 以逗号分隔，带前缀后缀
        String str1 = DATA.stream().collect(Collectors.joining(SPLIT_CHAR, "{", "}"));
        System.out.println("Collectors.joining 带前缀后缀 : " + str1);

        // 以@分隔，不带前缀后缀
        String str2 = DATA.stream().collect(Collectors.joining(SPLIT_CHAR));
        System.out.println("Collectors.joining 不带前缀后缀 : " + str2);
    }
}
