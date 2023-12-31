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

    private static final List<String> DATA = Arrays.asList("moon1", "moon2", "moon3");

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

        System.out.println("String.join() 转化后的字符串 : " + substring);
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
