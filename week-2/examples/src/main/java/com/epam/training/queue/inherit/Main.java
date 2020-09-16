package com.epam.training.queue.inherit;

import com.epam.training.abstr.initial.IntegerLifoQueue;
import com.epam.training.abstr.initial.IntegerProducer;
import com.epam.training.abstr.initial.LoggingIntegerConsumer;

public class Main {
    public static void main(String[] args) {
        var queue = new IntegerLifoQueue();
        var producer = new IntegerProducer(queue);
        var consumer = new LoggingIntegerConsumer(queue);
        producer.produce();
        consumer.consumeAvailable();
    }
}
