package com.epam.training;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinkedMap<K, V> implements Map<K, V> {

    private Node<K, V> root = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Optional<Node<K, V>> possibleResult = findFirstNode(node -> node.getKey().equals(key));
        return possibleResult.isPresent();
    }

    @Override
    public boolean containsValue(Object value) {
        Optional<Node<K, V>> possibleResult = findFirstNode(node -> node.getValue().equals(value));
        return possibleResult.isPresent();
    }

    @Override
    public V get(Object key) {
        Optional<V> possibleResult = findFirstNode(node -> node.getKey().equals(key))
                .map(Node::getValue);
        return possibleResult.orElse(null);
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        Optional<Node<K, V>> possibleResult = findFirstNode(node -> node.getKey().equals(key));
        if (possibleResult.isPresent()) {
            V originalValue = possibleResult.get().getValue();
            possibleResult.get().setValue(value);
            return originalValue;
        }
        Node<K, V> newNode = new Node<K, V>(key, value, root);
        root = newNode;
        size += 1;
        return null;
    }

    @Override
    public V remove(Object key) {

        if (root == null) {
            return null;
        }

        if (root.getKey().equals(key)) {
            V result = root.getValue();
            root = root.getNext();
            this.size -= 1;
            return result;
        }

        Node<K, V> current = root.getNext();
        Node<K, V> previous = root;
        while (current != null) {
            if (current.getKey().equals(key)) {
                V result = current.getValue();
                previous.setNext(current.getNext());
                this.size -= 1;
                return result;
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public void clear() {
        this.root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        iterate(entry -> result.add(entry.getKey()));
        return result;
    }

    @Override
    public Collection<V> values() {
        Collection<V> result = new LinkedList<>();
        iterate(entry -> result.add(entry.getValue()));
        return result;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new HashSet<>();
        iterate(result::add);
        return result;
    }

    private Optional<Node<K, V>> findFirstNode(Predicate<Node<K, V>> criteria) {
        Node<K, V> current = root;
        while (current != null) {
            if (criteria.test(current)) {
                return Optional.of(current);
            }
            current = current.getNext();
        }
        return Optional.empty();
    }

    private void iterate(Consumer<Node<K, V>> sink) {
        Node<K, V> current = root;
        while (current != null) {
            sink.accept(current);
            current = current.getNext();
        }
    }

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

}
