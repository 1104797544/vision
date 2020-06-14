package com.jzf.leetcode;

/**
 * Leetcode 203 移除链表元素
 * @author JiaZhengfeng
 * @version 1.0
 * @see com.jzf.datastructure
 * @CreateDate 2019/1/27
 */
public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //1.不使用虚拟头结点
    public ListNode removeElements(ListNode head, int val) {
        //1.如果头结点的值等于val
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        //2.排除了头结点等于val,则可以先找到要被删除的结点的前驱结点
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    //2.使用虚拟头结点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //找到要被删除的结点的前驱结点
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    //3.使用递归
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

}
