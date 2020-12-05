package react.impl;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LimitedQueue<T> {

    private LinkedList<T> items = new LinkedList<>();
    private long limit;

    public LimitedQueue(long limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(T item) {
        if (items.size()>=limit) {
            items.removeLast();
        }
        items.addFirst(item);
    }

    public synchronized Optional<T> dequeue() {
        try {
            T item = items.removeLast();
            return Optional.of(item);
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public synchronized long size() {
        return items.size();
    }
}
