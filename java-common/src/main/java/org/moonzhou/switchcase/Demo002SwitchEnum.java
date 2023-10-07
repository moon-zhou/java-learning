package org.moonzhou.switchcase;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/7 17:45
 */
public class Demo002SwitchEnum {

    public static void main(String[] args) {
        WeekConfig weekDay = WeekConfig.MONDAY;
        testDay(weekDay);

        // switch param no-null
        // WeekConfig notDay = null;
        // testDay(notDay);
    }

    private static void testDay(WeekConfig weekDay) {
        switch (weekDay) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("1");
            case SATURDAY, SUNDAY -> System.out.println("0");
            // default -> throw new IllegalArgumentException("error");
            default -> System.out.println("-1");
        }
    }

    private enum WeekConfig {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY,
        ;
    }
}
