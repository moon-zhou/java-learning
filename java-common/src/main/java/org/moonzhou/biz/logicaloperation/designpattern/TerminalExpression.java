package org.moonzhou.biz.logicaloperation.designpattern;

// 终结符表达式类
class TerminalExpression implements Expression {
    private String term;

    public TerminalExpression(String term) {
        this.term = term;
    }

    @Override
    public String interpret() {
        return "+" + term + "*";
    }
}
