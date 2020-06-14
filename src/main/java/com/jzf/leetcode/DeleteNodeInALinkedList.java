package com.jzf.leetcode;

/**
 * Leetcode 237 删除链表中的元素
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/27
 */
public class DeleteNodeInALinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 没有给出head结点，因为不需要
     * node结点即是要删除的结点，因为node结点是非尾结点，所以可以将node的后一个结点的值复制给node，
     * 然后跳过node结点的下一个结点(即删除node结点的下一个结点)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
