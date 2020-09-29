package com.epam.training.queue.inherit;

import com.epam.training.abstr.initial.IntegerFifoQueue;

public class IntegerLifoQueue extends IntegerFifoQueue {

    @Override
    public Integer dequeue() {
        return this.itemList.removeFirst();
    }
}
