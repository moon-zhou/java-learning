package org.moonzhou.datatype;

import java.math.BigDecimal;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2024/11/25 13:40
 */
public class BigDecimal003 {
    public static void main(String[] args) {
        // 精度缺失
        double amount1 = 0.02;
        double amount2 = 0.03;
        System.out.println(amount2 - amount1);

        // 精度缺失，构造函数的结果可能不可预测，可能会出现创建时为0.1，但实际xxx
        BigDecimal amount3 = new BigDecimal(0.02);
        BigDecimal amount4 = new BigDecimal(0.03);
        System.out.println(amount4.subtract(amount3));

        // 准确
        BigDecimal amount5 = new BigDecimal(Double.toString(0.02));
        BigDecimal amount6 = new BigDecimal(Double.toString(0.03));
        System.out.println(amount6.subtract(amount5));

        // 准确
        BigDecimal amount7 = BigDecimal.valueOf(0.02);
        BigDecimal amount8 = BigDecimal.valueOf(0.03);
        System.out.println(amount8.subtract(amount7));
    }
}
