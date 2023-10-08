package org.moonzhou.designpattern.behavioral.chainofresponsible.commander;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrcSoldier implements RequestHandler {
    @Override
    public boolean canHandleRequest(Request req) {
        return req.getRequestType() == RequestType.COLLECT_TAX;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public void handle(Request req) {
        req.markHandled();
        log.info("{} handling request \"{}\"", name(), req);
    }

    @Override
    public String name() {
        return "Orc soldier";
    }
}