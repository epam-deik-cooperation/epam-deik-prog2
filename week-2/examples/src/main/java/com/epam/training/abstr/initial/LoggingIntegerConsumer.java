package com.epam.training.abstr.initial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingIntegerConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingIntegerConsumer.class);

    private IntegerFifoQueue queue;

    public LoggingIntegerConsumer(IntegerFifoQueue queue) {
        this.queue = queue;
    }

    public void consumeAvailable() {
        while (!queue.isEmpty()) {
            LOGGER.info("The next number is {}", queue.dequeue());
        }
    }

}
