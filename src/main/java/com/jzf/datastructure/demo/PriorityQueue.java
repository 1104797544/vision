package com.jzf.datastructure.demo;


import com.jzf.datastructure.demo.Interface.Queue;

/**
 * 使用堆(最大堆)优先队列
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/31
 * @see com.jzf.datastructure
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队 按照优先级 最大元素出队
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
