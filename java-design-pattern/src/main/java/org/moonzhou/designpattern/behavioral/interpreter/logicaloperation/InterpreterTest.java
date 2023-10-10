package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/10 18:01
 */
public class InterpreterTest {
    public static void main(String[] args) {
        // true
        // final var tokenString = "true false true || &&";

        // false
        final var tokenString = "true false true && &&";
        Interpreter.interpret(tokenString);
    }
}
