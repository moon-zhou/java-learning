package org.moonzhou.nullcheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author moon zhou
 * @version 1.0
 * @description: Optional.of Optional.ofNullable
 *
 * Optional.of 参数不能为null，否则NPE
 * Optional.ofNullable 参数可为null，不会NPE
 *
 * @date 2023/8/26 20:05
 */
public class Demo001OptionOf {

    public static void main(String[] args) {
        testOptionalOf();

        System.out.println("--------------------------");

        testOptionalOfNullable();

        System.out.println("--------------------------");

        testOptionalOfNullable2();
    }

    private static void testOptionalOf() {
        try {
            // value值不存在
            String str = null;

            Optional.of(str);
        } catch (Exception e) {
            // NPE
            System.out.println(e);
        }


        try {
            // value值存在
            String str = "hello world";

            String value = Optional.of(str).get();
            System.out.println(value);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void testOptionalOfNullable() {
        try {
            // value值不存在
            String str = null;

            Optional<String> optional = Optional.ofNullable(str);
            optional.ifPresent(System.out::println);
        } catch (Exception e) {
            // No NPE
            System.out.println(e);
        }

        try {
            // value值存在
            String str = "hello world";

            Optional<String> optional = Optional.ofNullable(str);
            optional.ifPresent(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void testOptionalOfNullable2() {
        User moon = new User("moon", 18, GenderEnum.MALE);
        // User moon = null;
        String name = Optional.ofNullable(moon)
                .map(o -> o.getName())
                .orElseGet(() -> { return "no user name...";});
        System.out.println(name);

        Optional.ofNullable(moon).ifPresentOrElse(u -> System.out.println("user is found"),
                () -> System.out.println("user is not found"));


        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("moon", 18, GenderEnum.MALE),
                new User("moon1", 1, GenderEnum.MALE),
                new User("moon2", 1, GenderEnum.FEMALE)
        ));
        List<User> maleList = userList.stream().filter(user -> user.getGender().equals(GenderEnum.MALE)).toList();
        System.out.println(maleList);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        private String name;
        private Integer age;
        private GenderEnum gender;
    }

    @Getter
    // @NoArgsConstructor
    // @AllArgsConstructor
    private enum GenderEnum {
        MALE,
        FEMALE,
        OTHER
    }
}
