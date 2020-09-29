package com.epam.training.abstr.refactored.queue;

public class IntegerFifoQueue extends AbstractQueue {
    @Override
    public Integer dequeue() {
        return itemList.removeLast();
    }
}