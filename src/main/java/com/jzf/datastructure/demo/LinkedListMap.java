package com.jzf.datastructure.demo;

import com.jzf.datastructure.Interface.Map;


public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {

        private K key;

        private V value;

        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        public Node(K key) {
            this(key, null, null);
        }

        @Override
        public String toString() {
            return this.key.toString() + ":" + this.value.toString();
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedListMap() {
        dummyHead = null;
        size = 0;
    }

    private Node getNode(K key) {
        if (key == null) {
            return null;
        }
        if (dummyHead == null) {
            return null;
        }
        Node cur = dummyHead.next;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V value) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
