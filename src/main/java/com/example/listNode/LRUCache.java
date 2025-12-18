package com.example.listNode;

import java.util.HashMap;

class LRUCache {

    // 双向列表
    public class ListNode{
        public ListNode prev;
        public ListNode next;

        public int val;

        public ListNode(){};
        public ListNode(int val){
            this.val = val;
        }

    }

    private HashMap<Integer,ListNode> map = new HashMap();
    private int size = 0;

    // 头尾节点
    public ListNode lNode = new ListNode();
    public ListNode rNode = new ListNode();


    public LRUCache(int capacity) {
        this.size = capacity;
        lNode.next = rNode;
        rNode.prev = lNode;
    }

    public int get(int key) {
        return map.get(key).val;
    }

    public void put(int key, int value) {

        ListNode node = new ListNode(value);
        map.put(key,node);

        // 链表添加数据，从左边添加。
        ListNode next = lNode.next;
        lNode.next = node;
        node.prev = lNode;
        node.next = next;
        next.prev = node;


        // 判断是否超出，超出从链表右边删除。
        if(this.size<map.size()){
            // 删除map
            map.remove(rNode.prev.val);
            // 删除链表
            rNode.prev = rNode.prev.prev;
            rNode.prev.prev.next = rNode;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */