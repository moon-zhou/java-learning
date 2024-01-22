package org.moonzhou.datatype;

import java.util.Date;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/1/10 09:32
 */
public class Long2Date {
    public static void main(String[] args) {
        Long l = 1704849990L;
        System.out.println(new Date(l));
    }
}
