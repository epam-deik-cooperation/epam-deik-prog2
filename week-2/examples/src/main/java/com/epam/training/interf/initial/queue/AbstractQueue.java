package com.epam.training.interf.initial.queue;

import java.util.LinkedList;

public abstract class AbstractQueue {

    protected LinkedList<Integer> itemList = new LinkedList<>();

    public void enqueue(Integer item) {
        itemList.addFirst(item);
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public abstract Integer dequeue();
}
