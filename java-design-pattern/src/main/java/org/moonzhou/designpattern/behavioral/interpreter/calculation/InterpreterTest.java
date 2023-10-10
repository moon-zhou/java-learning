package org.moonzhou.designpattern.behavioral.interpreter.calculation;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/9 15:59
 */
public class InterpreterTest {
    public static void main(String[] args) {
        // the halfling kids are learning some basic math at school
        // define the math string we want to parse
        final var tokenString = "4 3 2 - 1 + *";

        Interpreter.interpret(tokenString);
    }
}
