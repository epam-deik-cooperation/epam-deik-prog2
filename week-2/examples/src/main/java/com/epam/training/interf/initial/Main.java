package com.epam.training.interf.initial;

import com.epam.training.interf.initial.consumer.LoggingIntegerConsumer;
import com.epam.training.interf.initial.queue.IntegerLifoQueue;

public class Main {
    public static void main(String[] args) {
        var queue = new IntegerLifoQueue();
        var producer = new IntegerProducer(queue);
        var consumer = new LoggingIntegerConsumer(queue);
        producer.produce();
        consumer.consumeAvailable();
    }
}
