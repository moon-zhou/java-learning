package org.moonzhou.biz;

public class Demo006LanguageDetector {
    public static String detectLanguage(String input) {
        boolean hasChinese = false;
        boolean hasEnglish = false;

        for (char c : input.toCharArray()) {
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                    || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) {
                hasChinese = true;
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                hasEnglish = true;
            }
        }

        if (hasChinese && hasEnglish) {
            return "Mixed";
        } else if (hasChinese) {
            return "Chinese";
        } else if (hasEnglish) {
            return "English";
        } else {
            return "Unknown";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Language of 'Hello World': " + detectLanguage("Hello World")); // English
        System.out.println("Language of '你好世界': " + detectLanguage("你好世界")); // Chinese
        System.out.println("Language of 'Hello 你好': " + detectLanguage("Hello 你好")); // Mixed
        System.out.println("Language of 'abc123': " + detectLanguage("abc123")); // English
        System.out.println("Language of '中文字符': " + detectLanguage("中文字符")); // Chinese
    }
}
