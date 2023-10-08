package org.moonzhou.designpattern.behavioral.chainofresponsible.commander;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrcKing {

    private List<RequestHandler> handlers;

    public OrcKing() {
        buildChain();
    }

    /**
     * in spring application, objects instantiate have 2 way:
     *
     * IService is interface, have many implements
     * 1. private final Map<String, IService> IServiceMap; // map key is service name
     * 2. private final List<IService> IServiceList;
     */
    private void buildChain() {
        handlers = Arrays.asList(new OrcCommander(), new OrcOfficer(), new OrcSoldier());
    }

    /**
     * Handle request by the chain.
     */
    public void makeRequest(Request req) {
        handlers
                .stream()
                .sorted(Comparator.comparing(RequestHandler::getPriority))
                .filter(handler -> handler.canHandleRequest(req))
                .findFirst()
                .ifPresent(handler -> handler.handle(req));
    }
}