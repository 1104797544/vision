package com.jzf.datastructure.demo;


import com.jzf.leetcode.Interface.Merger;

/**
 * 线段树-数组实现
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/31
 * @see com.jzf.datastructure
 * @since V9.0
 */
public class SegmentTree<E> {

    private E[] tree;

    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] array, Merger merger) {
        this.merger = merger;
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        tree = (E[]) new Object[4 * array.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置，创建表示区间[l, r]的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        //递归终止条件 创建叶子结点
        if (l == r ){
            tree[treeIndex] = data[l];
            return;
        }

        //分别获取左右子节点的索引
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        //分别创建左右子树
        buildSegmentTree(leftTreeIndex, l , mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        //与业务相关
        tree[treeIndex] = merger.merger(tree[leftTreeIndex] , tree[rightTreeIndex]);
    }

    /**
     * 查询[queryL,queryR]区间的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length - 1 || queryR < 0 || queryR > data.length - 1 || queryL > queryR) {
            throw new IllegalArgumentException("Query Failed.");
        }
        return query(0, 0,data.length - 1, queryL, queryR);
    }

    /**
     * 查询以treeIndex为根结点表示的[l, r]区间内[queryL, queryR]区间的值
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //递归终止条件1 找到叶子结点
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            //仅从右子树查询
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            //仅从左子树查询
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        //递归终止条件2
        return merger.merger(leftResult, rightResult);
    }

    public E get(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Get Failed.");
        }
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }

            if (i != tree.length - 1) {

            }
        }
        res.append("]");
        return res.toString();
    }

}
