package com.epam.training.interf.refactored;

import java.util.stream.IntStream;

import com.epam.training.interf.refactored.queue.IntegerQueue;

public class IntegerProducer {

    private IntegerQueue queue;

    public IntegerProducer(IntegerQueue queue) {
        this.queue = queue;
    }

    public void produce() {
        IntStream.range(0, 10)
            .forEach(queue::enqueue);
    }
}
