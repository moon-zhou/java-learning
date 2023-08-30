package org.moonzhou.compare;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @author moon zhou
 * @version 1.0
 * @description: enum compare
 * @date 2023/8/30 21:10
 */
public class Demo001EnumCompare {
    public static void main(String[] args) {

        String monday = "MONDAY";
        System.out.println(monday.equals(WeekConfig.MONDAY));
        System.out.println(monday.equals(WeekConfig.MONDAY.name()));
        System.out.println(monday.equals(WeekConfig.SUNDAY.name()));

        System.out.println(WeekConfig.MONDAY);
        System.out.println(WeekConfig.MONDAY.name());
        System.out.println(WeekConfig.MONDAY.toString());

        System.out.println("\n");

        System.out.println(monday.equals(WeekConfigDetail.MONDAY));
        System.out.println(monday.equals(WeekConfigDetail.MONDAY.name()));
        System.out.println(monday.equals(WeekConfigDetail.SUNDAY.name()));

        System.out.println(WeekConfigDetail.MONDAY);
        System.out.println(WeekConfigDetail.MONDAY.name());
        System.out.println(WeekConfigDetail.MONDAY.toString());
    }

    private enum WeekConfig {
        MONDAY,
        Tuesday,
        Wednesday,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY,
        ;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private enum WeekConfigDetail {
        MONDAY("星期一", "07"),
        Tuesday("星期二", "06"),
        Wednesday("星期三", "05"),
        THURSDAY("星期四", "04"),
        FRIDAY("星期五", "03"),
        SATURDAY("星期六", "02"),
        SUNDAY("星期日", "01"),

        OTHER("other", "00"),
        ;

        private String name;
        private String order;
    }
}
