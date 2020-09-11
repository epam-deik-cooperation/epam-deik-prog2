package com.epam.training.interf.refactored;

import com.epam.training.interf.refactored.consumer.impl.LoggingIntegerConsumer;
import com.epam.training.interf.refactored.queue.impl.IntegerLifoQueue;

public class Main {
    public static void main(String[] args) {
        var queue = new IntegerLifoQueue();
        var producer = new IntegerProducer(queue);
        var consumer = new LoggingIntegerConsumer(queue);
        producer.produce();
        consumer.consumeAvailable();
    }
}
