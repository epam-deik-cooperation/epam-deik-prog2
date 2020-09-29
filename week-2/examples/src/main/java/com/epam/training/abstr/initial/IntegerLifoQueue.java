package com.epam.training.abstr.initial;

public class IntegerLifoQueue extends IntegerFifoQueue {

    @Override
    public Integer dequeue() {
        return this.itemList.removeFirst();
    }
}
