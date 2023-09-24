package org.moonzhou.datatype;

import java.time.LocalDateTime;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/24 16:27
 */
public class LocalDateTime001 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 不会修改原值
        now.plusSeconds(5);
        System.out.println(now);

        LocalDateTime after5seconds = now.plusSeconds(5);
        System.out.println(after5seconds);
    }
}
