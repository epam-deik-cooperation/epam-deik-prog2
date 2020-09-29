package com.epam.training.abstr.initial;

import java.util.stream.IntStream;

public class IntegerProducer {

    private IntegerFifoQueue queue;

    public IntegerProducer(IntegerFifoQueue queue) {
        this.queue = queue;
    }

    public void produce() {
        IntStream.range(0, 10)
            .forEach(queue::enqueue);
    }
}
