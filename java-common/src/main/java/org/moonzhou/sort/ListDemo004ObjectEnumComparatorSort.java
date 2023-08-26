package org.moonzhou.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/26 17:43
 */
public class ListDemo004ObjectEnumComparatorSort {

    public static void main(String[] args) {
        List<Week> sortList1 = init();
        sortList1.sort(Comparator.comparing(day -> WeekConfig.getByName(day.getName()).getOrder()));
        System.out.println(sortList1);

        System.out.println("-----------------------------------");

        List<Week> sortList2 = init2();
        sortList2.sort((o1, o2) -> {
            WeekConfig weekConfig1 = WeekConfig.getOptionalByName(o1.getName()).orElse(WeekConfig.OTHER);
            WeekConfig weekConfig2 = WeekConfig.getOptionalByName(o2.getName()).orElse(WeekConfig.OTHER);
            return weekConfig1.getOrder().compareTo(weekConfig2.getOrder());
        });
        System.out.println(sortList2);
    }

    private static List<Week> init() {
        // java.base/java.util.ImmutableCollections.uoe
        // List<Week> list = Stream.of(
        //         new Week("星期一", "Monday"),
        //         new Week("星期二", "Tuesday"),
        //         new Week("星期三", "Wednesday"),
        //         new Week("星期四", "Thursday"),
        //         new Week("星期五", "Friday"),
        //         new Week("星期六", "Saturday"),
        //         new Week("星期日", "Sunday")).toList();

        List<Week> list = new ArrayList<>(){
            {
                add(new Week("星期一", "Monday"));
                add(new Week("星期二", "Tuesday"));
                add(new Week("星期三", "Wednesday"));
                add(new Week("星期四", "Thursday"));
                add(new Week("星期五", "Friday"));
                add(new Week("星期六", "Saturday"));
                add(new Week("星期日", "Sunday"));
            }
        };

        System.out.println(list);

        return list;
    }

    private static List<Week> init2() {
        // java.base/java.util.ImmutableCollections.uoe
        // List<Week> list = Stream.of(
        //         new Week("星期一", "Monday"),
        //         new Week("星期二", "Tuesday"),
        //         new Week("星期三", "Wednesday"),
        //         new Week("星期四", "Thursday"),
        //         new Week("星期五", "Friday"),
        //         new Week("星期六", "Saturday"),
        //         new Week("星期日", "Sunday"),
        //         new Week("INIT", "INIT")).toList();
        List<Week> list = new ArrayList<>(Arrays.asList(
                new Week("星期一", "Monday"),
                new Week("星期二", "Tuesday"),
                new Week("星期三", "Wednesday"),
                new Week("星期四", "Thursday"),
                new Week("星期五", "Friday"),
                new Week("星期六", "Saturday"),
                new Week("星期日", "Sunday"),
                new Week("INIT", "INIT")
        ));
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

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Week {
        private String name;
        private String nameEn;
    }
}
