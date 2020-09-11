package com.epam.training.interf.initial;

import java.util.stream.IntStream;

import com.epam.training.interf.initial.queue.AbstractQueue;

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
