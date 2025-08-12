package org.moonzhou.datatype;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author moon zhou
 * @description 设置小数点位数时，必然伴随数据的精度丢失，需要设置RoundingMode（四舍五入的规则）
 * @email
 * @date 2025/8/12 10:00
 **/
public class BigDecimal004 {
    public static void main(String[] args) {
        String data = "99.99";

        BigDecimal bigDecimal = new BigDecimal(data);
        // Exception in thread "main" java.lang.ArithmeticException: Rounding necessary
        //bigDecimal.setScale(0);
        System.out.println(bigDecimal.setScale(0, RoundingMode.HALF_UP));
        System.out.println(bigDecimal);
    }
}
