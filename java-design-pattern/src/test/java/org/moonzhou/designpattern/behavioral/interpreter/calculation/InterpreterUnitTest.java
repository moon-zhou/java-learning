package org.moonzhou.designpattern.behavioral.interpreter.calculation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InterpreterUnitTest {
    @Test
    void shouldExecuteApplicationWithoutException() {
        assertDoesNotThrow(() -> Interpreter.interpret("4 3 2 - 1 + *"));
    }
}