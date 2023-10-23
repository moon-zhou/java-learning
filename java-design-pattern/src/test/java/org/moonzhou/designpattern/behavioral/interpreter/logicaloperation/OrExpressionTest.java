package org.moonzhou.designpattern.behavioral.interpreter.logicaloperation;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/20 17:48
 */
public class OrExpressionTest extends ExpressionTest<OrExpression>{

    public OrExpressionTest() {
        super(OrExpression::new);
    }

    @Override
    public Stream<Arguments> expressionProvider() {
        return prepareParameters(Boolean::logicalOr);
    }
}
