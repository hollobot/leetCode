package com.example.LeetCode75.链表;

public class 删除链表的中间节点 {

    public ListNode deleteMiddle(ListNode head) {
        ListNode k = head;
        ListNode m = new ListNode();
        m.next = head;

        while (k != null && k.next != null) {
            m = m.next;
            k = k.next.next;
        }
        m.next = m.next.next;
        return head;
    }
}
