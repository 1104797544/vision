package com.jzf.datastructure.demo;

/**
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/21
 * @see com.jzf.datastructure
 */
public class LinkedList<E> {

    //虚拟头结点
    private Node dummyHead;

    private int size = 0;


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

    public LinkedList() {
        this.dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    //按索引插入节点
    //关键,找到要插入的位置的前一个节点
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add faild.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = dummyHead.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    //返回指定位置的节点 应从第一个节点开始遍历
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get faild.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set faild.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public void setFirst(E e) {
        set(0, e);
    }

    public void setLast(E e) {
        set(size, e);
    }

    public boolean remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove faild.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = dummyHead.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return true;
    }

    public boolean removeFirst() {
        return remove(0);
    }

    public boolean removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder linkedList = new StringBuilder();
        linkedList.append("LinkedList:[");
        Node cur = dummyHead.next;
        while (cur != null) {
            linkedList.append(cur + "->");
            cur = cur.next;
        }
        linkedList.append("null]");
        return linkedList.toString();
    }


}
