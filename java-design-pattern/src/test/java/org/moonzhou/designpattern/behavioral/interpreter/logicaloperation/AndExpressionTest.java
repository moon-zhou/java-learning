package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

import org.junit.jupiter.params.provider.Arguments;

import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/20 17:48
 */
public class AndExpressionTest extends ExpressionTest<AndExpression>{

    public AndExpressionTest() {
        super(AndExpression::new);
    }

    @Override
    public Stream<Arguments> expressionProvider() {
        return prepareParameters(Boolean::logicalAnd);
    }
}
