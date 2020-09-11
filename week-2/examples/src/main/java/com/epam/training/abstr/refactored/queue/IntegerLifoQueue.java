package com.epam.training.abstr.refactored.queue;

public class IntegerLifoQueue extends AbstractQueue {

    @Override
    public Integer dequeue() {
        return this.itemList.removeFirst();
    }
}
