package com.epam.training.queue.noinherit;

import com.epam.training.abstr.initial.IntegerFifoQueue;

public class IntegerFifoQueueToIntegerLifoQueueAdapter {

    private IntegerFifoQueue inputQueue;
    private IntegerLifoQueue outputQueue;

    public IntegerFifoQueueToIntegerLifoQueueAdapter(IntegerFifoQueue inputQueue, IntegerLifoQueue outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    public void mapAvailable() {
        while (!inputQueue.isEmpty()) {
            outputQueue.enqueue(inputQueue.dequeue());
        }
    }
}
