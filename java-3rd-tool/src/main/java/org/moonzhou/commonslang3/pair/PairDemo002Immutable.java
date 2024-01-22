package org.moonzhou.commonslang3.pair;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.moonzhou.commonslang3.UserDto;

/**
 * @author moon zhou
 * @version 1.0
 * @description: Pair --> ImmutablePair (value can not change - but reference value can not change not means the value in object referenced, Thread safe)
 * @date 2024/1/22 13:53
 */
public class PairDemo002Immutable {

    public static void main(String[] args) {
        test();

        System.out.println();

        testObj();
    }

    private static void test() {
        ImmutablePair<String, Boolean> immutablePair = ImmutablePair.of("test1", true);
        System.out.println("左值：" + immutablePair.getLeft() + " 右值：" + immutablePair.getRight());

        // immutablePair.setValue(false); // java.lang.UnsupportedOperationException
        System.out.println("左值：" + immutablePair.getLeft() + " 右值：" + immutablePair.getRight());
    }

    private static void testObj() {
        UserDto moon = new UserDto(18, "moon");
        UserDto littleMoon = new UserDto(1, "little moon");

        ImmutablePair<UserDto, UserDto> immutablePair = ImmutablePair.of(moon, littleMoon);
        System.out.println("左值：" + immutablePair.getLeft() + " 右值：" + immutablePair.getRight());

        littleMoon.setAge(2);
        System.out.println("左值：" + immutablePair.getLeft() + " 右值：" + immutablePair.getRight());
    }
}
