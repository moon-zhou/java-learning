package org.moonzhou.designpattern.behavioral.chainofresponsible.commander;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/9/27 17:46
 */
public class ChainOfResponsibleTest {
    public static void main(String[] args) {
        var king = new OrcKing();
        king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "defend castle"));
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "torture prisoner"));
        king.makeRequest(new Request(RequestType.COLLECT_TAX, "collect tax"));
    }
}
