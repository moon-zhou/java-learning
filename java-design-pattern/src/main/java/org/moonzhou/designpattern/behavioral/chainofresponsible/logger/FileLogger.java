package org.moonzhou.designpattern.behavioral.chainofresponsible.logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.info("---File::Logger  {}", message);
    }
}