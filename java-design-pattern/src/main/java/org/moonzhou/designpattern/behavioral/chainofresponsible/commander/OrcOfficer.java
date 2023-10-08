package org.moonzhou.designpattern.behavioral.chainofresponsible.commander;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrcOfficer implements RequestHandler {
    @Override
    public boolean canHandleRequest(Request req) {
        return req.getRequestType() == RequestType.TORTURE_PRISONER;
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public void handle(Request req) {
        req.markHandled();
        log.info("{} handling request \"{}\"", name(), req);
    }

    @Override
    public String name() {
        return "Orc officer";
    }
}