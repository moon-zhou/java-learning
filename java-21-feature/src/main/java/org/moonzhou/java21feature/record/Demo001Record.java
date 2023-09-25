package org.moonzhou.java21feature.record;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/25 15:07
 */
public class Demo001Record {
    public static void main(String[] args) {
        Person p = new Person("John", 25);

        // before
        if (p instanceof Person) {
            System.out.println("name: " + p.name() + ", age:" + p.age());
        }

        // 可以直接解构记录字段
        /* if (p instanceof Person(String name, int age)) {
            System.out.println("name: " + name + ", age:" + age);
        } */

        // 或者
        /* switch (p) {
            case Person(String n, int a) ->{
                System.out.println("name: " + n + ", age: " + a);
            }
        } */
    }
}
