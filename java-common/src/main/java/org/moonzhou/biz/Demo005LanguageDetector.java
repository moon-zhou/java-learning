package org.moonzhou.biz;

public class Demo005LanguageDetector {
    public static boolean isChinese(String input) {
        for (char c : input.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEnglish(String input) {
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Is 'Hello World' English? " + isEnglish("Hello World")); // true
        System.out.println("Is '你好世界' Chinese? " + isChinese("你好世界")); // true
        System.out.println("Is 'Hello 你好' mixed? " + (isEnglish("Hello 你好") && isChinese("Hello 你好"))); // true
        System.out.println("Is 'abc123' English? " + isEnglish("abc123")); // true
        System.out.println("Is '中文字符' Chinese? " + isChinese("中文字符")); // true
    }
}
