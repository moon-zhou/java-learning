package org.moonzhou.string;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/9 11:02
 */
public class StringFormatDemo001 {
    public static void main(String[] args) {
        String format = "str result: %s";

        String stringResult = String.format(format, "this is a string.");
        System.out.println(stringResult);

        System.out.println(String.format("%%%s%%", "boy"));

        String longResult = String.format(format, 999L);
        System.out.println(longResult);
    }
}
