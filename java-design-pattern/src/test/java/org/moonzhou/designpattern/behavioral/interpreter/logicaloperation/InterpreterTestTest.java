package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InterpreterTestTest {

    @Test
    void shouldExecuteApplicationWithoutException() {
        assertDoesNotThrow(() -> InterpreterTest.main(new String[]{}));
    }
}