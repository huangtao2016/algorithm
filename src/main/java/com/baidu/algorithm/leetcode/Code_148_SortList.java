package com.baidu.algorithm.leetcode;

/**
 *  对链表排序
 *  时间复杂度: O(nlogn)
 *  空间复杂度: O(1)
 *
 *  利用快慢指针分割链表，然后进行归并
 *  需要确定递归结束条件
 */
public class Code_148_SortList {

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode sortList(ListNode head) {
         if (head == null) {
             return null;
         }

         if (head.next == null) {
             return head;
         }

         ListNode p1 = head;
         ListNode p2 = head;

         while (p2.next != null && p2.next.next != null) {
             p1 = p1.next;
             p2 = p2.next.next;
         }

         ListNode tail = p1;
         p1 = p1.next;
         tail.next = null;

         // 左边排序后返回左链表的开头
         ListNode L = sortList(head);
         // 右边排序后返回右链表的开头
         ListNode R = sortList(p1);

         return merge(L, R);
    }

    private ListNode merge(ListNode left, ListNode right) {

         ListNode pre = new ListNode(0);
         ListNode cur = pre;

         while (left != null && right != null) {
             if (left.val < right.val) {
                 cur.next = left;
                 cur = cur.next;
                 left = left.next;

             } else {
                 cur.next = right;
                 cur = cur.next;
                 right = right.next;
             }
         }

         if (left != null) {
             cur.next = left;
         }
         if (right != null) {
             cur.next = right;
         }

         return pre.next;
    }
}
