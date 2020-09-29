package com.epam.training.abstr.refactored;

import com.epam.training.abstr.refactored.consumer.LoggingIntegerConsumer;
import com.epam.training.abstr.refactored.queue.IntegerLifoQueue;

public class Main {
    public static void main(String[] args) {
        var queue = new IntegerLifoQueue();
        var producer = new IntegerProducer(queue);
        var consumer = new LoggingIntegerConsumer(queue);
        producer.produce();
        consumer.consumeAvailable();
    }
}
