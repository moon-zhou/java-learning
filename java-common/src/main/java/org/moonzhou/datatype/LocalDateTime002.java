package org.moonzhou.datatype;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/24 16:27
 */
public class LocalDateTime002 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.toString());
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
