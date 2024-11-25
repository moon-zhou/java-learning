package org.moonzhou.string;

/**
 *
 * javac StringAppend.java
 * javap -c StringAppend
 * java8, 拼接使用StringBuilder，但是Java17和Java21则不是
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/11/25 13:52
 */
public class StringAppend {
    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        String c = a + b;
        System.out.println(c);
    }
}
