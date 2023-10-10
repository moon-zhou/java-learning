package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

public class AndExpression implements Expression {

    private final Expression expressionLeft;
    private final Expression expressionRight;

    public AndExpression(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public boolean interpret() {
        return expressionLeft.interpret() && expressionRight.interpret();
    }
}