package org.moonzhou.function.consumer;

import java.util.function.Consumer;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/23 13:31
 */
public class Demo001Consumer {
    public static void main(String[] args) {

        Consumer<Integer> action1 = (x) -> {
            System.out.printf("对传进来的 %d 进行加1操作: %d \n", x, (x + 1));
        };
        Consumer<Integer> action2 = (x) -> {
            System.out.printf("对传进来的 %d 进行减1操作: %d \n", x, (x - 1));
        };
        Consumer<Integer> anction3 = action1.andThen(action2);

        // 先执行加法再执行减法
        System.out.println("执行anction1");
        action1.accept(3);

        System.out.println();
        System.out.println("执行anction2");
        action2.accept(3);

        System.out.println();
        System.out.println("执行anction3");
        anction3.accept(3);
    }
}
