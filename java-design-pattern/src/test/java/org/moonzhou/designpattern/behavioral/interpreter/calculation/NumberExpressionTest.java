package org.moonzhou.designpattern.behavioral.interpreter.calculation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberExpressionTest extends ExpressionTest<NumberExpression> {

    /**
     * Create a new test instance using the given test parameters and expected result
     */
    public NumberExpressionTest() {
        super("number", (f, s) -> f);
    }

    /**
     * Create a new set of test entries with the expected result
     *
     * @return The list of parameters used during this test
     */
    @Override
    public Stream<Arguments> expressionProvider() {
        return prepareParameters((f, s) -> f);
    }

    /**
     * Verify if the {@link NumberExpression#NumberExpression(String)} constructor works as expected
     */
    @ParameterizedTest
    @MethodSource("expressionProvider")
    void testFromString(NumberExpression first) throws Exception {
        final var expectedValue = first.interpret();
        final var testStringValue = String.valueOf(expectedValue);
        final var numberExpression = new NumberExpression(testStringValue);
        assertEquals(expectedValue, numberExpression.interpret());
    }

}