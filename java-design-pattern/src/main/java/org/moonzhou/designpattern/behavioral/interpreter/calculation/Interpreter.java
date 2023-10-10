package org.moonzhou.designpattern.behavioral.interpreter.calculation;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/9 15:46
 */
@Slf4j
public class Interpreter {
    /**
     * Program entry point.
     */
    public static void interpret(String tokenString) {

        // the stack holds the parsed expressions
        var stack = new Stack<Expression>();

        // tokenize the string and go through them one by one
        var tokenList = tokenString.split(" ");
        for (var s : tokenList) {
            if (isOperator(s)) {
                // when an operator is encountered we expect that the numbers can be popped from the top of
                // the stack
                var rightExpression = stack.pop();
                var leftExpression = stack.pop();
                log.info("popped from stack left: {} right: {}",
                        leftExpression.interpret(), rightExpression.interpret());
                var operator = getOperatorInstance(s, leftExpression, rightExpression);
                log.info("operator: {}", operator);
                var result = operator.interpret();
                // the operation result is pushed on top of the stack
                var resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
                log.info("push result to stack: {}", resultExpression.interpret());
            } else {
                // numbers are pushed on top of the stack
                var i = new NumberExpression(s);
                stack.push(i);
                log.info("push to stack: {}", i.interpret());
            }
        }
        // in the end, the final result lies on top of the stack
        log.info("result: {}", stack.pop().interpret());
    }

    /**
     * Checks whether the input parameter is an operator.
     * @param s input string
     * @return true if the input parameter is an operator
     */
    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    /**
     * Returns correct expression based on the parameters.
     * @param s input string
     * @param left expression
     * @param right expression
     * @return expression
     */
    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        return switch (s) {
            case "+" -> new PlusExpression(left, right);
            case "-" -> new MinusExpression(left, right);
            default -> new MultiplyExpression(left, right);
        };
    }
}
