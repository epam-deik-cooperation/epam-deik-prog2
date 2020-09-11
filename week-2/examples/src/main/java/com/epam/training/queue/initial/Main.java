package com.epam.training.queue.initial;

import com.epam.training.abstr.initial.IntegerFifoQueue;
import com.epam.training.abstr.initial.IntegerProducer;
import com.epam.training.abstr.initial.LoggingIntegerConsumer;

public class Main {
    public static void main(String[] args) {
        var queue = new IntegerFifoQueue();
        var producer = new IntegerProducer(queue);
        var consumer = new LoggingIntegerConsumer(queue);
        producer.produce();
        consumer.consumeAvailable();
    }
}