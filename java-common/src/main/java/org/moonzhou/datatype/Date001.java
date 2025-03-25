package org.moonzhou.datatype;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/12/6 14:07
 */
public class Date001 {
    public static void main(String[] args) throws ParseException {
        // Date date = new Date(1725018348064546849L);
        Date date = new Date(1725018348064546849L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println(sf.format(date));

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssZ");
        // String dateStr = "20241104000000Z";
        // try {
        //     Date date1 = sdf.parse(dateStr);
        //     System.out.println(date1);
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssZ");
        // LocalDateTime dateTime = LocalDateTime.parse("20241104000000Z", formatter);
        // System.out.println(dateTime);

        String input = "20250310000000Z";
        // 定义格式解析器，使用模式匹配字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssX");
        // 解析为带时区的日期时间对象
        ZonedDateTime zdt = ZonedDateTime.parse(input, formatter);
        // 转换为 Instant，再转为 Date
        Date date2 = Date.from(zdt.toInstant());
        System.out.println(date2); // 输出取决于默认时区，但 Date 内部值正确

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String input2 = input.substring(0, input.length() - 1);
        Date outputDate2 = sdf.parse(input2);
        System.out.println(outputDate2);
    }
}
