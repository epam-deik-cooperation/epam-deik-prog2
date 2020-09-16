package com.epam.training.interf.refactored.queue;

public interface IntegerQueue {
    void enqueue(Integer item);
    boolean isEmpty();
    Integer dequeue();
}
