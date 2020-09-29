package com.epam.training.interf.refactored.consumer.impl;

import com.epam.training.interf.refactored.consumer.IntegerConsumer;
import com.epam.training.interf.refactored.queue.IntegerQueue;

public abstract class AbstractConsumer implements IntegerConsumer {

    private IntegerQueue queue;

    public AbstractConsumer(IntegerQueue queue) {
        this.queue = queue;
    }

    public void consumeAvailable() {
        while (!queue.isEmpty()) {
            processNext(queue.dequeue());
        }
    }

    protected abstract void processNext(Integer item);

}
