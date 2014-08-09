package com.nateriver.app.leetcode;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private Map<Integer,LinkNode> keymap = new HashMap<>();
    private final LinkNode head = new LinkNode();

    public LRUCache(int capacity){
        //if(capacity == 0 || capacity < 0) throw new Exception("capacity must be a negtive number");
        this.capacity = capacity;
    }

    public int get(int key) {
        if(keymap.containsKey(key)){
            LinkNode node = keymap.get(key);
            moveToHead(node);
            return node.value;
        }
        else return -1;
    }

    public void set(int key, int value) {
        LinkNode node = keymap.get(key);
        //put to the head;
        if(node == null){
            if(keymap.size() == capacity) eliminate();
            node = new LinkNode(key,value);
            keymap.put(key,node);
        }
        node.value = value;
        moveToHead(node);
    }

    private void eliminate(){
        //remove one
        LinkNode cur = head;
        while (cur.next !=null){
            cur = cur.next;
        }
        cur.pre.next = null;
        keymap.remove(cur.key);
    }

    private void moveToHead(LinkNode node){
        LinkNode pre = node.pre;
        LinkNode next = node.next;
        if(pre != null){
            pre.next = next;
            if(next != null) next.pre = pre;
        }
        LinkNode headnext = head.next;
        node.next = headnext;
        head.next = node;
        node.pre = head;
        if(headnext != null) headnext.pre = node;
    }

    public static void main(String[] args) throws Exception {
        LRUCache cache = new LRUCache(1);
        cache.set(2,1);
        System.out.println(cache.get(2));
        cache.set(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

}

class LinkNode{
    public LinkNode next;
    public LinkNode pre;
    public int value;
    public int key;
    public LinkNode(){}
    public LinkNode(int key, int vaule){
        this.key = key;
        this.value = vaule;
    }
}
