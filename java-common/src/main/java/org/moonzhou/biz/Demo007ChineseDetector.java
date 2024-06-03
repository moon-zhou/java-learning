package org.moonzhou.biz;

import java.util.regex.Pattern;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/5/31 09:06
 */
public class Demo007ChineseDetector {
    private static final Pattern CHINESE_CHARACTER_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]");
    private static final Pattern ENGLISH_CHARACTER_PATTERN = Pattern.compile("^[a-zA-Z\\s\\.\\,!:]*$");
    private static final Pattern ENGLISH_ALPHABETIC_CHARACTER_PATTERN = Pattern.compile("^[a-zA-Z\\s]*$");

    public static boolean containsChineseCharacters(String input) {
        return CHINESE_CHARACTER_PATTERN.matcher(input).find();
    }

    public static boolean containsOnlyEnglishCharacters(String input) {
        return ENGLISH_CHARACTER_PATTERN.matcher(input).matches();
    }

    public static boolean containsEnglishCharacters(String input) {
        return ENGLISH_ALPHABETIC_CHARACTER_PATTERN.matcher(input.replaceAll("[^a-zA-Z\\s]", "")).matches();
    }

    public static void main(String[] args) {
        testChinese();

        System.out.println();

        testEnglish();

        System.out.println();

        testEnglishAlphabet();
    }

    private static void testChinese() {
        String input1 = "Hello World";
        System.out.println(containsChineseCharacters(input1)); // false

        String input2 = "你好世界";
        System.out.println(containsChineseCharacters(input2)); // true

        String input3 = "Hello 你好";
        System.out.println(containsChineseCharacters(input3)); // true
    }

    private static void testEnglish() {
        String input1 = "Hello World";
        System.out.println(containsOnlyEnglishCharacters(input1)); // true

        String input2 = "你好世界";
        System.out.println(containsOnlyEnglishCharacters(input2)); // false

        String input3 = "Hello 你好";
        System.out.println(containsOnlyEnglishCharacters(input3)); // false

        String input4 = "Hello, World!";
        System.out.println(containsOnlyEnglishCharacters(input4)); // true
    }

    private static void testEnglishAlphabet() {
        String input1 = "Hello World";
        System.out.println(containsEnglishCharacters(input1)); // true

        String input2 = "你好世界";
        System.out.println(containsEnglishCharacters(input2)); // false

        String input3 = "Hello 你好";
        System.out.println(containsEnglishCharacters(input3)); // false

        String input4 = "Hello, World!";
        System.out.println(containsEnglishCharacters(input4)); // true
    }
}
