package org.moonzhou.datatype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/11/9 14:24
 */
public class Map001 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("001 001", "001");
        map.put("002 002", "002");

        System.out.println(map);
        System.out.println(map.get("001 001"));
    }
}
