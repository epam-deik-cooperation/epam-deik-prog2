package com.epam.training.queue.noinherit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifoLoggingIntegerConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(LifoLoggingIntegerConsumer.class);

    private IntegerLifoQueue queue;

    public LifoLoggingIntegerConsumer(IntegerLifoQueue queue) {
        this.queue = queue;
    }

    public void consumeAvailable() {
        while (!queue.isEmpty()) {
            LOGGER.info("The next number is {}", queue.dequeue());
        }
    }

}
