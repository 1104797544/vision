package com.jzf.datastructure.demo;


import com.jzf.datastructure.demo.Interface.Stack;

import java.util.LinkedList;

/**
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/27
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    @Override
    public int getSize() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getLast();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }
}
