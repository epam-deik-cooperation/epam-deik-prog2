package com.epam.training.interf.refactored.queue.impl;

import java.util.LinkedList;

import com.epam.training.interf.refactored.queue.IntegerQueue;

public abstract class AbstractQueue implements IntegerQueue {

    protected LinkedList<Integer> itemList = new LinkedList<>();

    public void enqueue(Integer item) {
        itemList.addFirst(item);
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public abstract Integer dequeue();
}
