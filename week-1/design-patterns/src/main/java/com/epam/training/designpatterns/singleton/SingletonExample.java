package com.epam.training.designpatterns.singleton;

public class SingletonExample {
    public static void main(String[] args) {
        var logger = Logger.getInstance();
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning");
        logger.error("This is an error");
    }
}
