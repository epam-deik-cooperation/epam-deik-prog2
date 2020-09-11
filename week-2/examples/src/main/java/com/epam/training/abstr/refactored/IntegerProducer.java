package com.epam.training.abstr.refactored;

import java.util.stream.IntStream;

import com.epam.training.abstr.refactored.queue.AbstractQueue;

public class IntegerProducer {

    private AbstractQueue queue;

    public IntegerProducer(AbstractQueue queue) {
        this.queue = queue;
    }

    public void produce() {
        IntStream.range(0, 10)
            .forEach(queue::enqueue);
    }
}
