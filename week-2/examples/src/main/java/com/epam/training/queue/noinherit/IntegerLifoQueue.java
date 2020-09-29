package com.epam.training.queue.noinherit;

import java.util.LinkedList;

public class IntegerLifoQueue {

    protected LinkedList<Integer> itemList = new LinkedList<>();

    public void enqueue(Integer item) {
        itemList.addFirst(item);
    }

    public Integer dequeue() {
        return itemList.removeFirst();
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

}
