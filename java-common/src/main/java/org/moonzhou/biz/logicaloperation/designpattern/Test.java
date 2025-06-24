package org.moonzhou.biz.logicaloperation.designpattern;

/**
 * 测试类
 * 带有括号的运算符不支持
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        // 输入的逻辑表达式
        String expression = "AAA and BBB or CCC and DDD or EEE";

        // 解析表达式并生成 SQL 条件
        Expression sqlCondition = Parser.parse(expression);

        // 输出结果
        System.out.println("Generated SQL Condition:");
        System.out.println(sqlCondition.interpret());
    }

    private static void test2() {
        // 测试用例
        String[] testCases = {
                "AAA and BBB", // 简单 AND
                "AAA or BBB", // 简单 OR
                "AAA and BBB or CCC and DDD or EEE", // 混合 AND 和 OR
                "AAA and (BBB or CCC) and DDD", // 嵌套表达式  TODO not effective
                "AAA or BBB or CCC or DDD", // 多个 OR
                "AAA and BBB and CCC and DDD", // 多个 AND
                "AAA", // 单个单词
                "", // 空表达式
                "AAA and (BBB or CCC) and (DDD or EEE)" // 复杂嵌套表达式 TODO not errective
        };

        // 运行测试
        for (String expression : testCases) {
            try {
                Expression sqlCondition = Parser.parse(expression);
                System.out.println("Input: " + expression);
                System.out.println("Output: " + sqlCondition.interpret());
                System.out.println("-----------------------------");
            } catch (Exception e) {
                System.out.println("Input: " + expression);
                System.out.println("Error: " + e.getMessage());
                System.out.println("-----------------------------");
            }
        }
    }

    private static void test3() {
        String expression = "AAA and BBB and CCC and DDD";
        Expression sqlCondition = Parser.parse(expression);
        System.out.println(sqlCondition.interpret());
    }
}