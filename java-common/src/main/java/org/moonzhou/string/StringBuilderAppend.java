package org.moonzhou.string;

/**
 * javac StringBuilderAppend.java
 * javap -c StringBuilderAppend
 *
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/11/25 13:53
 */
public class StringBuilderAppend {
    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        StringBuilder c = new StringBuilder();
        c.append(a).append(b);
        System.out.println(c);
    }
}
