package org.moonzhou.designpattern.behavioral.chainofresponsible.logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.info("---Standard Console::Logger  {}", message);
    }
}