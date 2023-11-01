package org.moonzhou.datatype;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/11/1 15:33
 */
public class IntegerDemo001 {
    public static void main(String[] args) {
        Integer num1Below127 = 10;
        Integer num2Below127 = 10;
        System.out.println(num1Below127 == num2Below127);
        System.out.println(num1Below127.equals(num2Below127));

        Integer num1Up127 = 1000;
        Integer num2Up127 = 1000;
        System.out.println(num1Up127 == num2Up127);
        System.out.println(num1Up127.equals(num2Up127));
    }
}
