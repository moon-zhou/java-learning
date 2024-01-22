package org.moonzhou.commonslang3.pair;

import org.apache.commons.lang3.tuple.MutablePair;
import org.moonzhou.commonslang3.UserDto;

/**
 * @author moon zhou
 * @version 1.0
 * @description: Pair --> MutablePair (value can change, Thread not safe)
 * @date 2024/1/22 13:53
 */
public class PairDemo001Mutable {

    public static void main(String[] args) {
        test();

        System.out.println();

        testObj();
    }

    private static void test() {
        MutablePair<String, Boolean> mutablePair = MutablePair.of("test1", true);
        System.out.println("左值：" + mutablePair.getLeft() + " 右值：" + mutablePair.getRight());

        mutablePair.setLeft("test2");
        mutablePair.setRight(false);
        System.out.println("左值：" + mutablePair.getLeft() + " 右值：" + mutablePair.getRight());
    }

    private static void testObj() {
        UserDto moon = new UserDto(18, "moon");
        UserDto littleMoon = new UserDto(1, "little moon");

        MutablePair<UserDto, UserDto> mutablePair = MutablePair.of(moon, littleMoon);
        System.out.println("左值：" + mutablePair.getLeft() + " 右值：" + mutablePair.getRight());

        littleMoon.setAge(2);
        mutablePair.setLeft(littleMoon);
        mutablePair.setRight(moon);
        System.out.println("左值：" + mutablePair.getLeft() + " 右值：" + mutablePair.getRight());
    }
}
