package org.moonzhou.designpattern.behavioral.chainofresponsible.logger;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/8 21:28
 */
public class LoggerChain {
    public static AbstractLogger getChainOfLoggers() {
        ErrorLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        FileLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        ConsoleLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}
