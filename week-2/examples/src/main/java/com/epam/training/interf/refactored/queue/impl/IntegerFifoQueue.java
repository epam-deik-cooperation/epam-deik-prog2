package com.epam.training.interf.refactored.queue.impl;

public class IntegerFifoQueue extends AbstractQueue {
    @Override
    public Integer dequeue() {
        return itemList.removeLast();
    }
}