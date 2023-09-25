package org.moonzhou.datatype;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/25
 */
public class BigDecimal002 {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("15.00");
        BigDecimal b2 = new BigDecimal("5.00");

        BigDecimal subtractVal = b1.subtract(b2).stripTrailingZeros();

        // 1E+1
        System.out.println(subtractVal);
        System.out.println(subtractVal.toString());

        // 10
        System.out.println(subtractVal.toPlainString());
        System.out.println(new BigDecimal(subtractVal.toPlainString()));
    }

}
