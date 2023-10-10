package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/10 13:24
 */
@Slf4j
public class Interpreter {

    public static void interpret(String tokenString) {
        var stack = new Stack<Expression>();

        var tokenList = tokenString.split(" ");
        for (var s : tokenList) {
            if (isOperator(s)) {
                var rightExpression = stack.pop();
                var leftExpression = stack.pop();
                var operator = getOperatorInstance(s, leftExpression, rightExpression);
                boolean result = operator.interpret();

                var resultExpression = new TerminalExpression(result);
                stack.push(resultExpression);
            } else {
                var i = new TerminalExpression(s);
                stack.push(i);
            }
        }

        log.info("result: {}", stack.pop().interpret());
    }

    private static boolean isOperator(String s) {
        return s.equals("or") || s.equals("||") || s.equals("and") || s.equals("&&");
    }

    private static Expression getOperatorInstance(String s, Expression left, Expression right) {
        return switch (s) {
            case "or", "||" -> new OrExpression(left, right);
            case "and", "&&" -> new AndExpression(left, right);
            default -> throw new IllegalArgumentException("operation char is illegal");
        };
    }
}
