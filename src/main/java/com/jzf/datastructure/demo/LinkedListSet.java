package com.jzf.datastructure.demo;

import com.jzf.datastructure.Interface.Set;

/**
 * 链表实现的集合
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/28
 * @see com.jzf.datastructure
 */
public class LinkedListSet<E> implements Set<E> {

    private java.util.LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new java.util.LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
