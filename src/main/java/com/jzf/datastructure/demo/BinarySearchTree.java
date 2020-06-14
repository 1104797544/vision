package com.jzf.datastructure.demo;

import java.util.Stack;

/**
 * 二叉搜索树的实现
 * 高度h 元素总数n
 * 则2^h - 1 = n(满二叉树)
 * 增、删、查的时间复杂度 评价O(logn) 最差O(n)
 * @author JiaZhengfeng
 * @version 1.0
 * @CreateDate 2019/1/27
 * @see com.jzf.datastructure
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node<E extends Comparable<E>> {

        private E e;

        private Node left;

        private Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

    }

    private Node<E> root;

    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //添加元素 递归版本1
/*    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo((E) node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        } else if (e.compareTo((E) node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }

        if (e.compareTo((E) node.e) > 0) {
            add(node.right, e);
        } else {
            add(node.left, e);
        }
        return;
    }*/

    //添加元素 递归版本2
    private Node add(Node node, E e) {
        //递归终止条件 找到新插入结点应该插入的位置
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo((E) node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo((E) node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo((E) node.e) > 0) {
            return contains(node.right, e);
        }
        return true;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历的非递归版本
    //使用栈来存储要遍历的结点 先入栈者后遍历
    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            //左右结点分别入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (null == node) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (null == node) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二叉树的层序遍历
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        LinkedListQueue<Node> queue = new LinkedListQueue<>();

        if (root != null) {
            queue.enqueue(root);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return (E) minimum(root).e;
    }

    private Node minimum(Node node) {
        if (null == node.left) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return (E) maximum(root).e;
    }

    private Node maximum(Node node) {
        if (null == node.right) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        //递归终止条件 要删除的即是最左边的结点
        if (null == node.left) {
            //被删除的结点可能有右子树
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        //返回左子树的根结点
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        //递归终止条件 要删除的即是最右边的结点
        if (null == node.right) {
            //被删除的结点可能有左子树
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        //返回右子树的根结点
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    //删除任意元素
    private Node remove(Node node, E e) {
        //递归终止条件1:没有找到要删除的结点
        if (null == node) {
            return null;
        }

        if (e.compareTo((E) node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo((E) node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        //递归终止条件2:找到要删除的结点
        } else {
            //要删除的结点只有右子树 则返回右子树的根结点作为子树的根结点
            if (null == node.left) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //要删除的结点只有左子树 则返回左子树的根结点作为子树的根结点
            if (null == node.right) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //要删除的结点含有左右子树
            //有两种方法可以解决 这里使用了方法1
            //1:找到要删除结点的后继结点即右子树的最小结点作为子树的根结点 并返回
            //2:找到要删除结点的前驱结点即左子树的最大结点作为子树的根结点 并返回
            Node successor = minimum(node.right);
            //必须先删除后继结点 才能将后继结点作为子树的根结点 顺序不能颠倒
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    public void generateString(Node node, int depth, StringBuilder res) {
        if (null == node) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    public String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-");
        }
        return res.toString();
    }

}
