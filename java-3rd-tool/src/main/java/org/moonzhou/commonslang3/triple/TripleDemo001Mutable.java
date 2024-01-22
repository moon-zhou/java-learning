package org.moonzhou.commonslang3.triple;

import org.apache.commons.lang3.tuple.MutableTriple;
import org.moonzhou.commonslang3.UserDto;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/1/22 15:24
 */
public class TripleDemo001Mutable {
    public static void main(String[] args) {
        test();

        System.out.println();

        testObj();
    }

    private static void test() {
        MutableTriple<String, Boolean, Integer> mutableTriple = MutableTriple.of("test1", true, 1);
        System.out.println(
                "左值：" + mutableTriple.getLeft() + " 中间值：" + mutableTriple.getMiddle() + " 右值：" + mutableTriple.getRight());

        mutableTriple.setLeft("test2");
        mutableTriple.setMiddle(false);
        mutableTriple.setRight(2);
        System.out.println(
                "左值：" + mutableTriple.getLeft() + " 中间值：" + mutableTriple.getMiddle() + " 右值：" + mutableTriple.getRight());
    }

    private static void testObj() {
        UserDto moon = new UserDto(18, "moon");
        UserDto littleLeftMoon = new UserDto(0, "little left moon");
        UserDto littleRightMoon = new UserDto(1, "little right moon");

        MutableTriple<UserDto, UserDto, UserDto> mutableTriple = MutableTriple.of(littleLeftMoon, moon, littleRightMoon);
        System.out.println(
                "左值：" + mutableTriple.getLeft() + " 中间值：" + mutableTriple.getMiddle() + " 右值：" + mutableTriple.getRight());

        UserDto newLittleLeftMoon = new UserDto(1, "new little left moon");
        UserDto newLittleRightMoon = new UserDto(2, "new little right moon");
        moon.setAge(19);
        mutableTriple.setLeft(newLittleLeftMoon);
        mutableTriple.setMiddle(moon);
        mutableTriple.setRight(newLittleRightMoon);
        System.out.println(
                "左值：" + mutableTriple.getLeft() + " 中间值：" + mutableTriple.getMiddle() + " 右值：" + mutableTriple.getRight());
    }
}
