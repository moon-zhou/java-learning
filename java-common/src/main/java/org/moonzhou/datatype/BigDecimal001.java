package org.moonzhou.datatype;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/22 17:42
 */
public class BigDecimal001 {
    public static void main(String[] args) {
        testPrecision();

        System.out.println("-------------------------------");
        testScale();

        System.out.println("-------------------------------");
        testStripTrailingZeros();
    }

    /**
     * float/double进行初始化时，会有精度丢失，在进行后续操作时
     */
    private static void testPrecision() {
        BigDecimal precisionError1 = new BigDecimal(1.745);
        BigDecimal precisionError2 = new BigDecimal(0.745);
        System.out.println(precisionError1);
        System.out.println(precisionError1.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(precisionError2);
        System.out.println(precisionError2.setScale(2, BigDecimal.ROUND_HALF_UP));

        System.out.println();

        BigDecimal precisionRight1 = new BigDecimal("1.745");
        BigDecimal precisionRight2 = new BigDecimal("0.745");
        System.out.println(precisionRight1);
        System.out.println(precisionRight1.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(precisionRight2);
        System.out.println(precisionRight2.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    /**
     * ROUND_UP：进位制，不管保留数字后面是大是小（0除外）都会进位；
     * ROUND_DOWN：保留设置数字，后面所有直接去除；
     * ROUND_HALF_UP：根据保留数字后一位进行四舍五入（ >=5 进位）；
     * ROUND_HALF_DOWN：根据保留数字后一位进行四舍五入（>5进位）。
     */
    private static void testScale() {
        // 设置BigDecimal初始值
        BigDecimal big = new BigDecimal("2.3513");
        // 2.4 保留1位小数，默认用四舍五入。
        // System.out.println(big.setScale(1)); // java.lang.ArithmeticException: Rounding necessary  对象的小数位超出了要保留的小数位

        // 向下取整  直接删除多余的小数，2.3513直接被截断位2.35
        System.out.println("向下取整：" + big.setScale(2, BigDecimal.ROUND_DOWN));
        System.out.println("向下取整：" + big.setScale(2, RoundingMode.DOWN));

        // 向上取整  2.36
        System.out.println("向上取整：" + big.setScale(2, BigDecimal.ROUND_UP));
        System.out.println("向上取整：" + big.setScale(2, RoundingMode.UP));

        // 2.4 四舍五入，向上舍入，2.3513变成2.4
        System.out.println("四舍五入，向上舍入(>=0.5): " + big.setScale(1, BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入，向上舍入(>=0.5): " + big.setScale(1, RoundingMode.HALF_UP));

        // 四舍五入，向下舍入，2.3513变成2.4（0.513）
        System.out.println("四舍五入，向上舍入(>0.5): " + big.setScale(1, BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入，向上舍入(>0.5): " + big.setScale(1, RoundingMode.HALF_DOWN));

        // 2.3
        BigDecimal big1 = new BigDecimal("2.35");
        System.out.println("四舍五入，向上舍入(>0.5): " + big.setScale(1, BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入，向上舍入(>0.5): " + big.setScale(1, RoundingMode.HALF_DOWN));

        // 2.3
        BigDecimal big2 = new BigDecimal("2.3413");
        System.out.println("四舍五入，向上舍入(>0.5): " + big2.setScale(1, BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入，向上舍入(>0.5): " + big2.setScale(1, RoundingMode.HALF_DOWN));

        // 2
        BigDecimal big3 = new BigDecimal("2.5");
        System.out.println("四舍五入，向上舍入(>0.5): " + big3.setScale(0, BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入，向上舍入(>0.5): " + big3.setScale(0, RoundingMode.HALF_DOWN));

        // 2
        BigDecimal big4 = new BigDecimal("1.6");
        System.out.println("四舍五入，向上舍入(>0.5): " + big4.setScale(0, BigDecimal.ROUND_HALF_DOWN));
        System.out.println("四舍五入，向上舍入(>0.5): " + big4.setScale(0, RoundingMode.HALF_DOWN));
    }

    private static void testStripTrailingZeros() {
        BigDecimal big1 = new BigDecimal("1.0000");
        BigDecimal big2 = new BigDecimal("1.1000");
        BigDecimal big3 = new BigDecimal("1.1100");
        BigDecimal big4 = new BigDecimal("1.1110");
        BigDecimal big5 = new BigDecimal("1");
        BigDecimal big6 = new BigDecimal("1.1");
        BigDecimal big7 = new BigDecimal("1.11");
        BigDecimal big8 = new BigDecimal("1.111");
        System.out.println(big1.stripTrailingZeros());
        System.out.println(big2.stripTrailingZeros());
        System.out.println(big3.stripTrailingZeros());
        System.out.println(big4.stripTrailingZeros());
        System.out.println(big5.stripTrailingZeros());
        System.out.println(big6.stripTrailingZeros());
        System.out.println(big7.stripTrailingZeros());
        System.out.println(big8.stripTrailingZeros());
    }
}
