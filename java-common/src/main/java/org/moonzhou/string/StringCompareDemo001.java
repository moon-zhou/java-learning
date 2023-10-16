package org.moonzhou.string;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/11 10:46
 */
public class StringCompareDemo001 {
    public static void main(String[] args) {
        compare1();

        System.out.println();

        compare2();
    }

    private static void compare1() {
        String str1 = "001";
        String str2 = "002";
        String str3 = "003";

        // -1,-2   <0
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
    }

    private static void compare2() {
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";

        // -1,-2   <0
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
    }
}
