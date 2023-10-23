package org.moonzhou.function.function;

import java.util.function.Function;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/23 13:46
 */
public class Demo001Function {
    public static void main(String[] args) {
        Function<Integer, Integer> action1 = (x) -> {
            System.out.printf("对传进来的 %d 进行加1操作: %d \n", x, (x + 1));
            return x + 1;
        };
        Function<Integer, Integer> action2 = (x) -> {
            System.out.printf("对传进来的 %d 进行-1操作:  %d \n", x, (x - 1));
            return (x - 1);
        };
        Function<Integer, Integer> andThen = action1.andThen(action2);
        Function<Integer, Integer> compose = action1.compose(action2);

        // 先执行加法在执行减法
        System.out.println("执行anction1");
        Integer action1Result = action1.apply(1);
        System.out.printf("执行anction1 result: %d \n", action1Result);

        System.out.println();
        System.out.println("执行anction2");
        Integer action2Result = action2.apply(1);
        System.out.printf("执行anction2 result: %d \n", action2Result);

        System.out.println();
        System.out.println("执行andThen返回的函数");
        Integer andThenResult = andThen.apply(1);
        System.out.printf("执行andThen result: %d \n", andThenResult);

        System.out.println();
        System.out.println("执行compose返回的函数");
        Integer composeResult = compose.apply(1);
        System.out.printf("执行composeResult result: %d \n", composeResult);
    }
}
