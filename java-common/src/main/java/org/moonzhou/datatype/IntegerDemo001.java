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
        System.out.println(num1Below127 == num2Below127); // true
        System.out.println(num1Below127.equals(num2Below127)); // true

        Integer num1Up127 = 1000;
        Integer num2Up127 = 1000;
        System.out.println(num1Up127 == num2Up127); // false
        System.out.println(num1Up127.equals(num2Up127)); // true

        // < java9，9之上已经废弃，
        // Integer orderStatus1 = new Integer(1);
        // Integer orderStatus2 = new Integer(1);
        // System.out.println(orderStatus1 == orderStatus2); // false

        String orderStatus1 = new String("1");
        String orderStatus2 = new String("1");
        System.out.println(Integer.valueOf(orderStatus1) == Integer.valueOf(orderStatus2)); // true
    }
}
