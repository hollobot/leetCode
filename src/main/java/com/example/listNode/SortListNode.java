package com.example.listNode;

/**
 * 链表排序
 */
public class SortListNode {

    public static void main(String[] args) {
       // [4,2,1,3]
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        ListNode root = sortList(head,null);

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }

    //拆分列表
    public  static ListNode sortList(ListNode left, ListNode right) {
        if(left==null){
            return left;
        }
        if (left.next == right) {
            // 切掉，避免循环
            left.next = null;
            return left;
        }
        ListNode q = left, m = left;
        while (q!=right && q.next!=right) {
            q = q.next.next;
            m = m.next;
        }
        ListNode mid = m;
        ListNode list1 = sortList(left, mid);
        ListNode list2 = sortList(mid, right);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    // 合并两个有序列表
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode root = new ListNode(),temp = root,temp1 = head1,temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp2 = temp2.next;
            } else {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }

        // 处理剩余部分
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }

        return root.next;
    }

    /**
     * 链表节点
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
