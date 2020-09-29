package com.epam.training.interf.refactored.queue.impl;

public class IntegerLifoQueue extends AbstractQueue {

    @Override
    public Integer dequeue() {
        return this.itemList.removeFirst();
    }
}
