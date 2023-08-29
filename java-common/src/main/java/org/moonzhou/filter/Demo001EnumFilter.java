package org.moonzhou.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.moonzhou.sort.ListDemo004ObjectEnumComparableSort;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/29 09:58
 */
public class Demo001EnumFilter {

    public static void main(String[] args) {
        System.out.println(WeekConfig.exist("no"));
        System.out.println(WeekConfig.exist("星期六"));

        System.out.println();

        System.out.println(WeekConfig.weekend("星期三"));
        System.out.println(WeekConfig.weekend("星期六"));
        System.out.println(WeekConfig.weekend("星期日"));
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private enum WeekConfig {
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

        public static boolean exist(String name) {
            return Arrays.stream(values())
                    .anyMatch(day -> day.getName().equals(name));
        }

        public static boolean weekend(String name) {
            return SATURDAY.getName().equals(name) || SUNDAY.getName().equals(name);
        }
    }
}
