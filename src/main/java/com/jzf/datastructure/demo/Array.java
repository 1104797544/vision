package com.jzf.datastructure.demo;

/**
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.sort
 * @CreateDate 2019/1/18
 */
public class Array<E> {

    private E[] data;

    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] array) {
        data = (E[]) new Object[array.length];
        for (int i =0; i < data.length; i++) {
            data[i] = array[i];
        }
        size = data.length;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IllegalArgumentException("Swap Faild.");
        }

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed, index is illegal.");

        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E getIndex(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("getIndex failed, index is illegal.");
        return data[index];
    }

    public E getLast() {
        return getIndex(size - 1);
    }

    public E getFirst() {
        return getIndex(0);
    }

    public void setIndex(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("setIndex failed, index is illegal.");
        data[index] = e;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed, index is illegal.");
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length != 0)
            resize(data.length / 2);
        return ret;
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

}
