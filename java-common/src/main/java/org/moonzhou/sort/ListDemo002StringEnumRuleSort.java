package org.moonzhou.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/26 17:02
 */
public class ListDemo002StringEnumRuleSort {
    public static void main(String[] args) {
        List<String> sortList1 = initList();
        // sortList1.sort((day1, day2) ->{
        //     return WeekConfig.getByName(day1).getOrder().compareTo(WeekConfig.getByName(day2).getOrder());
        // });
        sortList1.sort(Comparator.comparing(day -> WeekConfig.getByName(day).getOrder()));
        System.out.println(sortList1);

        System.out.println("-----------------------------------");

        List<String> sortList2 = initList2();
        // Collections.sort(sortList2, (o1, o2) -> {
        //     WeekConfig o1TradeType = WeekConfig.getOptionalByName(o1).orElse(WeekConfig.OTHER);
        //     WeekConfig o2TradeType = WeekConfig.getOptionalByName(o2).orElse(WeekConfig.OTHER);
        //     return o1TradeType.getOrder().compareTo(o2TradeType.getOrder());
        // });
        sortList2.sort((o1, o2) -> {
            WeekConfig o1TradeType = WeekConfig.getOptionalByName(o1).orElse(WeekConfig.OTHER);
            WeekConfig o2TradeType = WeekConfig.getOptionalByName(o2).orElse(WeekConfig.OTHER);
            return o1TradeType.getOrder().compareTo(o2TradeType.getOrder());
        });
        System.out.println(sortList2);
    }

    private static List<String> initList() {
        // 定义一个字符串的list集合,并排序
        // List<String> list = List.of("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"); // jdk9+
        List<String> list = Stream.of("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日").collect(Collectors.toList());
        System.out.println(list);
        return list;
    }

    private static List<String> initList2() {
        // 定义一个字符串的list集合,并排序
        // List<String> list = List.of("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日", "INIT"); // jdk9+
        List<String> list = Stream.of("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日", "INIT").collect(Collectors.toList());
        System.out.println(list);
        return list;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    enum WeekConfig {
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

        public static WeekConfig getByName(String name) {
            return Arrays.stream(values())
                    .filter(day -> day.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }

        public static Optional<WeekConfig> getOptionalByName(String name) {
            return Arrays.stream(values())
                    .filter(day -> day.getName().equals(name))
                    .findFirst();
        }
    }
}
