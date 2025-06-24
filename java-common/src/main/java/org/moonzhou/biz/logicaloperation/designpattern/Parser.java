package org.moonzhou.biz.logicaloperation.designpattern;

import java.util.ArrayList;
import java.util.List;

// 解析器类
class Parser {
    public static Expression parse(String expression) {
        String[] orParts = expression.split(" " + Operator.OR + " ");
        List<Expression> orExpressions = new ArrayList<>();

        for (String orPart : orParts) {
            String[] andParts = orPart.split(" " + Operator.AND + " ");
            List<Expression> andExpressions = new ArrayList<>();

            for (String andPart : andParts) {
                andExpressions.add(new TerminalExpression(andPart.trim()));
            }

            if (andExpressions.size() > 1) {
                orExpressions.add(new AndExpression(andExpressions));
            } else {
                orExpressions.add(new AndExpression(andExpressions)); // 即使只有一个条件，也包装成 AndExpression
            }
        }

        if (orExpressions.size() > 1) {
            return new OrExpression(orExpressions);
        } else {
            return orExpressions.get(0); // 只有一个条件时，直接返回
        }
    }
}