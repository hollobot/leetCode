package com.example.LeetCode75.链表;

public class 链表最大孪生和 {
    public int pairSum(ListNode head) {
        ListNode l = head;
        ListNode r = null;

        ListNode k = head.next.next;
        ListNode m = head;
        while (k != null && k.next != null) {
            k = k.next.next;
            m = m.next;
        }

        ListNode right = m.next;
        m.next = null;
        while (right != null) {
            ListNode temp = right.next;
            right.next = r;
            right = temp;
            r = r.next;
        }
        int max = 0;
        while (l != null) {
            max = Math.max(max, l.val + r.val);
            l = l.next;
            r = r.next;
        }

        return max;
    }
}
