package org.moonzhou.designpattern.behavioral.interpreter.calculation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTestTest {
    @Test
    void shouldExecuteApplicationWithoutException() {
        assertDoesNotThrow(() -> InterpreterTest.main(new String[]{}));
    }
}