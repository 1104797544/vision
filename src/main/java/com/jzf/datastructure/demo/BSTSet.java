package com.jzf.datastructure.demo;

import com.jzf.datastructure.demo.Interface.Set;

/**
 * 二叉搜索树实现的集合
 *
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/27
 * @see com.jzf.datastructure
 */
public class BSTSet<E extends Comparable> implements Set<E> {

    private BinarySearchTree bst;

    public BSTSet() {
        bst = new BinarySearchTree();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
