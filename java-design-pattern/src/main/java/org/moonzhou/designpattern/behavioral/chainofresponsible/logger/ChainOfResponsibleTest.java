package org.moonzhou.designpattern.behavioral.chainofresponsible.logger;

/**
 * @author moon zhou
 * @version 1.0
 * @description:
 * @date 2023/10/8 21:30
 */
public class ChainOfResponsibleTest {
    public static void main(String[] args) {
        AbstractLogger logger = LoggerChain.getChainOfLoggers();

        // ---: Standard Console::Logger  this is an information.
        logger.logMessage(AbstractLogger.INFO, "this is an information.");

        // ---: File::Logger  this is a debug level information.
        // ---: Standard Console::Logger  this is a debug level information.
        logger.logMessage(AbstractLogger.DEBUG, "this is a debug level information.");

        // ---: Error Console::Logger  this is a error level information.
        // ---: File::Logger  this is a error level information.
        // ---: Standard Console::Logger  this is a error level information.
        logger.logMessage(AbstractLogger.ERROR, "this is a error level information.");
    }
}
