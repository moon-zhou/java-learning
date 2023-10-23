package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InterpreterUnitTest {

    @Test
    void shouldExecuteApplicationWithoutException() {
        assertDoesNotThrow(() -> Interpreter.interpret("true false true && &&"));
    }
}