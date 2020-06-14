package com.jzf.datastructure.demo;


import com.jzf.datastructure.demo.Interface.Stack;

/**
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/19
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack () {
        array = new Array<>();
    }

    public ArrayStack (int capacity) {
        array = new Array<>(capacity);
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }
}
