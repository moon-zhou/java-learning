package org.moonzhou.datatype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/12/19 18:22
 */
public class ArrayStringJoin {
    public static void main(String[] args) {
        int size = 0;

        for (int i = 0; i <= size; i++) {
            System.out.println(i);
        }

        List<String> bizPropertyCodes = new ArrayList<>(){{
            add("code1");
            add("code2");
            add("code3");
        }};
        System.out.println(String.join(",", bizPropertyCodes));

        String result = bizPropertyCodes.stream()
                .map(code -> code + " = :" + code)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
