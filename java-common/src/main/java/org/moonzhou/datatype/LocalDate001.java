package org.moonzhou.datatype;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/11/10 10:53
 */
public class LocalDate001 {
    public static void main(String[] args) {
        // change 2 today
        LocalDate today = LocalDate.of(2023, 11, 10);

        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy-MM")));

        LocalDate now = LocalDate.now();
        System.out.println(now.toString());
        LocalDate yesterday = now.minusDays(1);
        LocalDate tomorrow = now.plusDays(1);

        System.out.println(yesterday.isBefore(now));
        System.out.println(now.isBefore(tomorrow));

        System.out.println();
        System.out.println(now.isAfter(yesterday));
        System.out.println(tomorrow.isAfter(now));

        System.out.println();
        System.out.println(now.isEqual(today));

        System.out.println();
        System.out.println(yesterday.isAfter(now));
        System.out.println(now.isAfter(now));

    }
}
