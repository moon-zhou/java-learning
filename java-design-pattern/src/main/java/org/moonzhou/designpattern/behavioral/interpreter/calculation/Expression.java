package org.moonzhou.designpattern.behavioral.interpreter.calculation;

public abstract class Expression {

    public abstract int interpret();

    @Override
    public abstract String toString();
}