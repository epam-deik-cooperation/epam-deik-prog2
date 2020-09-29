package com.epam.training.queue.noinherit;

import com.epam.training.abstr.initial.IntegerFifoQueue;
import com.epam.training.abstr.initial.IntegerProducer;

public class Main {
    public static void main(String[] args) {
        var fifoQueue = new IntegerFifoQueue();
        var lifoQueue = new IntegerLifoQueue();
        var queueAdapter = new IntegerFifoQueueToIntegerLifoQueueAdapter(fifoQueue, lifoQueue);
        var producer = new IntegerProducer(fifoQueue);
        var consumer = new LifoLoggingIntegerConsumer(lifoQueue);
        producer.produce();
        queueAdapter.mapAvailable();
        consumer.consumeAvailable();
    }
}