package com.epam.training.interf.initial.queue;

public class IntegerFifoQueue extends AbstractQueue {
    @Override
    public Integer dequeue() {
        return itemList.removeLast();
    }
}