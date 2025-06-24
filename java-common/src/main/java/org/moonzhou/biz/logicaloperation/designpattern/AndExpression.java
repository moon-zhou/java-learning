package org.moonzhou.biz.logicaloperation.designpattern;

import java.util.ArrayList;
import java.util.List;

// And表达式类
class AndExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String interpret() {
        StringBuilder sb = new StringBuilder();
        for (Expression expr : expressions) {
            sb.append(expr.interpret()).append(" ");
        }
        return "MATCH(bizObject) AGAINST('" + sb.toString().trim() + "' IN BOOLEAN MODE)";
    }
}