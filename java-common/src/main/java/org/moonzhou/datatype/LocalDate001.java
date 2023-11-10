package org.moonzhou.datatype;

import java.time.LocalDate;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/11/10 10:53
 */
public class LocalDate001 {
    public static void main(String[] args) {
        // change 2 today
        LocalDate taday = LocalDate.of(2023, 11, 10);

        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);
        LocalDate tomorrow = now.plusDays(1);

        System.out.println(yesterday.isBefore(now));
        System.out.println(now.isBefore(tomorrow));

        System.out.println();
        System.out.println(now.isAfter(yesterday));
        System.out.println(tomorrow.isAfter(now));

        System.out.println();
        System.out.println(now.isEqual(taday));

        System.out.println();
        System.out.println(yesterday.isAfter(now));
        System.out.println(now.isAfter(now));

    }
}
