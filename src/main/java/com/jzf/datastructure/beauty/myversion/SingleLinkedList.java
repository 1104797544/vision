package com.jzf.datastructure.beauty.myversion;

import java.util.Stack;

/**
 * <Description> <br>
 *
 * @author jzf <br>
 * @version 1.0 <br>
 * @taskId <br>
 * @CreateDate 2020/6/13 <br>
 * @see com.jzf.datastructure.beauty.basic <br>
 * @since V9.0 <br>
 */
public class SingleLinkedList<E> {

    private Node<E> head;

    private Node<E> sentinel;

    private int length = 0;

    public SingleLinkedList() {
        this.head = new Node<>();
        this.sentinel = new Node<>();
        this.head.next = sentinel;
    }

    public SingleLinkedList(Node<E> node) {
        this.head = new Node<>();
        this.sentinel = new Node<>();
        this.head.next = sentinel;
        addFirst(node);
    }

    public void add(int i, E data) {
        add(i, new Node<>(data, null));
    }

    /**
     * 添加元素到尾部
     * @param data
     */
    public void add(E data) {
        Node<E> node = new Node<>(data, null);
        addLast(node);
    }

    /**
     * 添加元素到头部
     * @param data
     */
    public void addFirst(E data) {
        Node<E> node = new Node<>(data, null);
        addFirst(node);
    }

    /**
     * 按索引访问
     * @param i
     * @return
     */
    public E get(int i) {
        return getNode(i).data;
    }

    /**
     * 判断某个元素是否存在
     * @param data
     * @return
     */
    public boolean contains(E data) {
        if (length == 0 || data == null) {
            return false;
        }
        boolean contains = false;
        Node<E> p = this.head.next;
        while (p.next != null) {
            if (p.next.data == data) {
                contains = true;
                break;
            }
            p = p.next;
        }
        return contains;
    }

    /**
     * 根据索引删除
     * @param i
     */
    public void remove(int i) {
        checkIndex(i);

        if (i == 0) {
            removeFirst();
        }
        else if (i == length - 1){
            removeLast();
        }
        else {
            // p最终指向被删除的前一个结点
            // pnext指向被删除的结点
            Node<E> p = this.sentinel;
            Node<E> pnext = p.next;
            int j = 0;
            while (j != i) {
                pnext = pnext.next;
                p = p.next;
                ++j;
            }
            p.next = p.next.next;
            removeNode(pnext);
        }
    }

    /**
     * 删除指定值
     * 从senntinel开始遍历,因为sentinel没有值,所以比较值的操作从第一个结点开始即sentinel.next
     * 如果找到对应的节点,先保存该结点Node temp = p.next,再将当前结点指向下下个结点,p.next=p.next.next,再删除该节点removeNode(temp)
     * @param data
     */
    public boolean remove(E data) {
        boolean has = false;
        Node p = this.sentinel;
        while (p.next != null) {
           if (p.next.data == data) {
               Node temp = p.next;
               p.next = p.next.next;
               removeNode(temp);
               has = true;
               break;
           }
           p = p.next;
        }
        return has;
    }

    public void reverse() {
        Stack<Node> stack = new Stack<>();
        Node<E> p = this.head.next;

        while (p != null) {

        }

    }

    /**
     * 遍历链表中所有元素
     */
    public void traverse() {
        StringBuilder sb = new StringBuilder();
        Node<E> p = this.sentinel.next;
        while (p != null) {
            sb.append(p.data.toString());
            p = p.next;
        }
        System.out.println(sb.toString());
    }

    /* 操作结点的私有方法 */

    /**
     * 移除第一个结点
     * 先保存原第一个结点,再将sentinel指向原第一个结点的下一个结点,最后将原第一个结点删除
     */
    private void removeFirst() {
        Node<E> temp = this.sentinel.next;
        this.sentinel.next = this.sentinel.next.next;
        removeNode(temp);
    }

    /**
     * 移除最后一个结点
     * 需要找到倒数第二个结点
     */
    public void removeLast() {
        Node<E> p = this.head;
        while (p.next.next != null) {
            p = p.next;
        }
        Node<E> node = p.next;
        p.next = null;
        removeNode(node);
    }

    /**
     * 删除结点
     * @param node
     * @return
     */
    private E removeNode(Node node) {
        --length;
        E data = (E) node.data;
        node = null;
        return data;
    }

    /**
     * 按索引查询结点
     * @param i
     * @return
     */
    private Node<E> getNode(int i) {
        checkIndex(i);
        Node<E> p = this.head.next;
        int j = 0;
        while (j != i) {
            p = p.next;
            j++;
        }
        return p.next;
    }

    /**
     * 将结点插入索引为i的位置
     * @param i
     * @param node
     */
    private void add(int i, Node<E> node) {
        checkIndex(i);
        Node<E> p = this.sentinel;
        int j = 0;
        if (j != i) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
    }

    /**
     * 插入第一个位置
     * 先将原来的第一个保存,再将哨兵指向新插入的第一个,再将新插入的第一个指向原来的第一个
     * @param node
     */
    private void addFirst(Node node) {
        node.next = this.sentinel.next;
        this.sentinel.next = node;
        ++length;
    }

    /**
     * 插入最后一个位置
     * 先找到原最后一个结点x,即x.next = null;再将原最后一个指向新插入的最后一个结点
     * 这里通过头指针遍历实现,即head.next.next=null;找到最后一个结点
     * @param node
     */
    private void addLast(Node node) {
        Node p = this.head.next;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;
        ++length;
    }

    private void checkIndex(int i) {
        if (length == 0 || i < 0 || i >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return (length == 0);
    }


    class Node<E> {

        private E data;

        private Node<E> next;

        Node () {
            this.data = null;
            this.next = null;
        }

        Node (E data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

}
