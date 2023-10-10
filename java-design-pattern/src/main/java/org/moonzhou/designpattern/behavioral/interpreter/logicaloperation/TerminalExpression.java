package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

public class TerminalExpression implements Expression {

    private final boolean data;

    public TerminalExpression(boolean data) {
        this.data = data;
    }

    public TerminalExpression(String data) {
        this.data = Boolean.parseBoolean(data);
    }

    @Override
    public boolean interpret() {
        return data;
    }
}