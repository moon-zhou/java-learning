package org.moonzhou.biz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/05/29 15:50
 */
public class Demo004LongArrayToSplitString {
    private static final String SPLIT_CHAR = ";";

    private static final Long[] LONG_ARRAY = {1L, 2L, 3L, 4L, 5L};

    public static void main(String[] args) {
        // 使用 toString 方法
        String str1 = Arrays.toString(LONG_ARRAY);
        System.out.println("使用 toString 方法: " + str1);

        // 使用 String.valueOf 方法
        String str2 = Arrays.stream(LONG_ARRAY)
                .map(Object::toString)
                .collect(Collectors.joining(";"));
        System.out.println("使用 String.valueOf 方法: " + str2);

        // 使用字符串拼接
        String str3 = "";
        for (Long longValue : LONG_ARRAY) {
            str3 += longValue + ";";
        }
        System.out.println("使用字符串拼接: " + str3);
    }
}
