package com.epam.training.queue.initial;

import java.util.LinkedList;

public class IntegerFifoQueue {

    protected LinkedList<Integer> itemList = new LinkedList<>();

    public void enqueue(Integer item) {
        itemList.addFirst(item);
    }

    public Integer dequeue() {
        return itemList.removeLast();
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

}