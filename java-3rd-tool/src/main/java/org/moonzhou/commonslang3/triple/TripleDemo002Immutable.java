package org.moonzhou.commonslang3.triple;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.moonzhou.commonslang3.UserDto;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/1/22 15:24
 */
public class TripleDemo002Immutable {
    public static void main(String[] args) {
        test();

        System.out.println();

        testObj();
    }

    private static void test() {
        ImmutableTriple<String, Boolean, Integer> immutableTriple = ImmutableTriple.of("test1", true, 1);
        System.out.println(
                "左值：" + immutableTriple.getLeft() + " 中间值：" + immutableTriple.getMiddle() + " 右值：" + immutableTriple.getRight());
    }

    private static void testObj() {
        UserDto moon = new UserDto(18, "moon");
        UserDto littleLeftMoon = new UserDto(0, "little left moon");
        UserDto littleRightMoon = new UserDto(1, "little right moon");

        ImmutableTriple<UserDto, UserDto, UserDto> immutableTriple = ImmutableTriple.of(littleLeftMoon, moon, littleRightMoon);
        System.out.println(
                "左值：" + immutableTriple.getLeft() + " 中间值：" + immutableTriple.getMiddle() + " 右值：" + immutableTriple.getRight());
    }
}
