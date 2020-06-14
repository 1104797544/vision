package com.jzf.datastructure.demo;

import com.jzf.datastructure.Interface.Queue;

/**
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/27
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {

        private E e;

        private Node next;

        public Node() {
            e = null;
            next = null;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;

    private Node tail;

    private int size = 0;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        if (isEmpty()) {
            head = new Node(e);
            tail = head;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Dequeue failed.");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Getfront failed.");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder linkedListQueue = new StringBuilder();
        linkedListQueue.append("LinkedListQue:head[");
        Node cur = head;
        while (cur != null) {
            linkedListQueue.append(cur + "->");
            cur = cur.next;
        }
        linkedListQueue.append("null]tail");
        return linkedListQueue.toString();
    }
}
