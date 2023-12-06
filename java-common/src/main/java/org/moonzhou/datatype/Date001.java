package org.moonzhou.datatype;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/12/6 14:07
 */
public class Date001 {
    public static void main(String[] args) {
        // Date date = new Date(1725018348064546849L);
        Date date = new Date(1725018348064546849L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println(sf.format(date));
    }
}
