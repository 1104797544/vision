package com.jzf.datastructure.demo;

import com.jzf.datastructure.Interface.Queue;

/**
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/20
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    //指向队首元素
    private int front = 0;
    //指向队尾元素的下一个位置
    private int tail = 0;
    //队列元素数量
    private int size = 0;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
         if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("LoopQueue is empty!");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() != 0) {
            resize(getCapacity() / 2);
        }
        return ret;

    }

    @Override
    public E getFront() {
        return data[front];
    }

    //获取队尾元素
    public E getTail() {
        return data[(tail - 1 + data.length) % data.length];
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder();
        queue.append(String.format("Queue: size = %d, capacity = %d\n", size, data.length - 1));
        queue.append(String .format("front = %d, tail = %d\n", front, tail));
        queue.append("[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            queue.append(data[i]);
            if ((i + 1) % data.length != tail) {
                queue.append(",");
            }
        }
        queue.append("]");
        return queue.toString();
    }
}
