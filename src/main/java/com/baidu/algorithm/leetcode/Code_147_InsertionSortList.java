package com.baidu.algorithm.leetcode;

/**
 *  对链表进行插入排序
 */
public class Code_147_InsertionSortList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            ListNode tmp = cur.next;

            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = tmp;
        }

        return dummy.next;
    }
}
