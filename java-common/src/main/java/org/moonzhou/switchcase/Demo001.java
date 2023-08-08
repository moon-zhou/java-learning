package org.moonzhou.switchcase;

import lombok.extern.slf4j.Slf4j;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/8/8 20:48
 */
@Slf4j
public class Demo001 {
    public static void main(String[] args) {
        try {
            log.info("lambdaSwitchCase1: {}", lambdaSwitchCase1("A"));
            log.info("lambdaSwitchCase1: {}", lambdaSwitchCase1("D"));
            log.info("lambdaSwitchCase1: {}", lambdaSwitchCase1("Error"));
        } catch (Exception e) {
            log.error("lambdaSwitchCase1 error: ", e);
        }


        log.info("\n");
        log.info("lambdaSwitchCase2: {}", lambdaSwitchCase2("A"));
        log.info("lambdaSwitchCase2: {}", lambdaSwitchCase2("C"));
        log.info("lambdaSwitchCase2: {}", lambdaSwitchCase2("Error"));


        log.info("\n");
        try {
            log.info("lambdaSwitchCase3: {}", lambdaSwitchCase3("A"));
            log.info("lambdaSwitchCase3: {}", lambdaSwitchCase3("C"));
            log.info("lambdaSwitchCase3: {}", lambdaSwitchCase3("Error"));
        } catch (Exception e) {
            log.error("lambdaSwitchCase3 error: ", e);
        }


        log.info("\n");
        log.info("lambdaSwitchCase4: {}", lambdaSwitchCase4("A"));
        log.info("lambdaSwitchCase4: {}", lambdaSwitchCase4("C"));
        log.info("lambdaSwitchCase4: {}", lambdaSwitchCase4("D"));
        log.info("lambdaSwitchCase4: {}", lambdaSwitchCase4("E"));
        log.info("lambdaSwitchCase4: {}", lambdaSwitchCase4("Error"));


        log.info("\n");
        try {
            log.info("calculate: {}", calculate("+", 1, 1));
            log.info("calculate: {}", calculate("-", 1, 1));
            log.info("calculate: {}", calculate("*", 1, 2));
            log.info("calculate: {}", calculate("/", 1, 2));
            log.info("calculate: {}", calculate("error", 1, 2));
        } catch (Exception e) {
            log.error("calculate error: ", e);
        }

    }

    private static int lambdaSwitchCase1(String str) {
        var result = switch (str) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            case "D" -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + str);
        };

        return result;
    }

    private static int lambdaSwitchCase2(String str) {
        int result;
        switch (str) {
            case "A" -> result = 1;
            case "B" -> result = 2;
            case "C" -> {
                result = 3;
                log.info("3!");
            }
            default -> {
                log.error("Unexpected value: {}", str);
                result = -1;
            }
        }

        return result;
    }

    private static int lambdaSwitchCase3(String str) {
        var result = switch (str) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> {
                log.info("3!");
                yield 3; // return，还是需要通过最后return返回（return前的log会有打印）
            }
            default -> throw new IllegalStateException("Unexpected value: " + str);
        };

        log.info("return result...");

        return result;
    }

    private static int lambdaSwitchCase4(String str) {
        var result = switch (str) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            case "D", "E", "F" -> 4;
            default -> 5;
        };

        return result;
    }

    private static double calculate(String operator, double x, double y) {
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> {
                if (y == 0) {
                    throw new IllegalArgumentException("Can't divide by 0");
                }
                yield x / y;
            }
            default -> throw new IllegalArgumentException("Unknown operator '%s'".formatted(operator));
        };
    }
}
