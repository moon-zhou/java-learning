package org.moonzhou.map;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/12/1 11:42
 */
public class Demo001NoKey {
    public static void main(String[] args) {
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "111");
        map.put(2L, "222");
        map.put(3L, "333");

        System.out.println(map.get(1L));
        System.out.println(map.get(9L));

        Map<Long, String> map1 = new HashMap<>();
        map1.put(1L, "111");
        map1.put(2L, "222");
        map1.put(3L, "333");

        Map<Long, String> map2 = new HashMap<>();
        map2.put(1L, "111");
        map2.put(2L, "222");
        map2.put(9L, "999");

        boolean consistent1 = true;
        boolean consistent2 = true;

        for (Map.Entry<Long, String> mapEntry : map.entrySet()) {
            Long key = mapEntry.getKey();
            String value = mapEntry.getValue();

            if (!StringUtils.equals(value, map1.get(key))) {
                consistent1 = false;
            }

            if (!StringUtils.equals(value, map2.get(key))) {
                consistent2 = false;
            }
        }

        System.out.println();
        System.out.println(consistent1);
        System.out.println(consistent2);
    }
}
