package com.epam.training.abstr.initial;

public class Main {
    public static void main(String[] args) {
        var queue = new IntegerLifoQueue();
        var producer = new IntegerProducer(queue);
        var consumer = new LoggingIntegerConsumer(queue);
        producer.produce();
        consumer.consumeAvailable();
    }
}
