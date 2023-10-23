package org.moonzhou.function.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/23 13:57
 */
public class Demo002BiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> action1 = (x, y) -> {
            System.out.printf("对传进来的 %d,%d 进行相加操作: %d \n", x, y, x + y);
            return x + y;
        };
        BiFunction<Integer, Integer, Integer>  action2 = (x, y) -> {
            System.out.printf("对传进来的  %d,%d 进行相减操作: %d \n", x, y, x - y);
            return x - y;
        };

        Function<Integer, Integer> function = (x) -> {
            System.out.printf("对传进来的 %d 进行-1操作:  %d \n", x, (x - 1));
            return (x - 1);
        };
        BiFunction<Integer, Integer, Integer> andThen = action1.andThen(function);

        // 先执行加法在执行减法
        System.out.println("执行anction1");
        Integer action1Result = action1.apply(1, 2);
        System.out.printf("执行anction1 result: %d \n", action1Result);

        System.out.println();
        System.out.println("执行anction2");
        Integer action2Result = action2.apply(2, 1);
        System.out.printf("执行anction2 result: %d \n", action2Result);

        System.out.println();
        System.out.println("执行andThen返回的函数");
        Integer andThenResult = andThen.apply(9, 1);
        System.out.printf("执行andThen result: %d \n", andThenResult);
    }
}
