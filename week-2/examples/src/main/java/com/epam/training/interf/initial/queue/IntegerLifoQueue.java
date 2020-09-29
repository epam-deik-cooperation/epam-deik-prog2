package com.epam.training.interf.initial.queue;

public class IntegerLifoQueue extends AbstractQueue {

    @Override
    public Integer dequeue() {
        return this.itemList.removeFirst();
    }
}
