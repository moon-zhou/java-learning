package org.moonzhou.biz.logicaloperation.designpattern;

import java.util.ArrayList;
import java.util.List;

// Or表达式类
class OrExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String interpret() {
        StringBuilder sb = new StringBuilder();
        for (Expression expr : expressions) {
            sb.append(expr.interpret()).append(" ").append(Operator.OR).append(" ");
        }
        // 去掉最后一个 " OR "
        return sb.substring(0, sb.length() - Operator.OR.length() - 2);
    }
}
