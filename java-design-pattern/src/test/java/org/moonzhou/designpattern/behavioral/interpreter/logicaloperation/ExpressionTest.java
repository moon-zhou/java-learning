package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.moonzhou.designpattern.behavioral.interpreter.calculation.NumberExpression;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/20 17:38
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class ExpressionTest<E extends Expression> {

    private final BiFunction<TerminalExpression, TerminalExpression, E> factory;

    public ExpressionTest(BiFunction<TerminalExpression, TerminalExpression, E> factory) {
        this.factory = factory;
    }

    static Stream<Arguments> prepareParameters(final LogicOperator logicOperator) {
        final var testData = new ArrayList<Arguments>();
        for (var i = 0; i < 10; i++) {
            for (var j = 0; j < 10; j++) {
                boolean left = i % 2 != 0;
                boolean right = j % 2 != 0;

                testData.add(Arguments.of(
                        new TerminalExpression(left),
                        new TerminalExpression(right),
                        logicOperator.applyAsBoolean(left, right)
                ));
            }
        }
        return testData.stream();
    }

    public abstract Stream<Arguments> expressionProvider();

    @ParameterizedTest
    @MethodSource("expressionProvider")
    void testInterpret(TerminalExpression first, TerminalExpression second, boolean result) {
        final var expression = factory.apply(first, second);
        assertNotNull(expression);
        assertEquals(result, expression.interpret());
    }

    interface LogicOperator {
        boolean applyAsBoolean(boolean left, boolean right);
    }
}
