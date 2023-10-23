package org.moonzhou.function.consumer;

import java.util.function.BiConsumer;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/23 13:42
 */
public class Demo002BiConsumer {

    public static void main(String[] args) {
        BiConsumer<Integer, Integer> action1 = (x, y) -> {
            System.out.printf("对传进来的 %d,%d 进行相加操作: %d \n", x, y, (x + y));
        };
        BiConsumer<Integer, Integer> action2 = (x, y) -> {
            System.out.printf("对传进来的 %d,%d 进行相减操作:  %d \n", x, y, (x - y));
        };
        BiConsumer<Integer, Integer> anction3 = action1.andThen(action2);

        // 先执行加法在执行减法
        System.out.println("执行anction1");
        action1.accept(1, 1);

        System.out.println();
        System.out.println("执行anction2");
        action2.accept(1, 1);

        System.out.println();
        System.out.println("执行anction3");
        anction3.accept(1, 1);
    }
}
