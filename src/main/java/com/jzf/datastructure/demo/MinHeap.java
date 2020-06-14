package com.jzf.datastructure.demo;

/**
 * 最小堆：子结点的值小于等于其父亲结点
 * 添加元素和删除最大元素的时间复杂度都是O(logn)
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2018/1/31
 * @see com.jzf.datastructure
 * @since V9.0
 */
public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MinHeap() {
        this.data = new Array<>();
    }

    public MinHeap(E[] array) {
        data = new Array<>(array);
        heapify();
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回结点的父亲结点的索引
     * @param index
     * @return
     */
    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index Illigal.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回结点左孩子的索引
     * @param index
     * @return
     */
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回结点右孩子的索引
     * @param index
     * @return
     */
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 元素上浮
     * @param k
     */
    public void siftUp(int k) {
        //如果结点非根结点 且 结点的父结点的值小于此结点
        while (k > 0 && data.getIndex(parent(k)).compareTo(data.getIndex(k)) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 获取最大元素
     * @return
     */
    public E findMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return data.getIndex(0);
    }

    /**
     * 删除最大元素
     * @return
     */
    public E extractMin() {
        E ret = findMin();

        //1.将最大元素与数组末尾的元素交换 并删除最大元素
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        //2.元素下沉
        siftDown(0);

        return ret;
    }

    /**
     * 元素下沉
     * @param k
     */
    public void siftDown(int k) {
        //如果结点含有左孩子 则需要对结点进行下沉
        while (leftChild(k) < data.getSize()) {
            //1.获取左右孩子中最小的那一个的索引
            int l = leftChild(k);
            if ((l + 1) < data.getSize() && data.getIndex(l + 1).compareTo(data.getIndex(l)) < 0) {
                l++;
            }
            //2.如果结点小于左右孩子 则跳出循环 否则交换结点与左右孩子中最小的那一个 继续循环
            if (data.getIndex(k).compareTo(data.getIndex(l)) <= 0) {
                break;
            }
            data.swap(k, l);
            k = l;
        }
    }

    /**
     * 删除最小元素并替换成新的元素
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMin();
        data.setIndex(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * 整理成堆
     * 从最后一个非叶子结点开始，对每一个结点进行下沉
     */
    public void heapify() {
        for (int i = parent(data.getSize() - 1); i >= 0; i++) {
            siftDown(i);
        }
    }

}
