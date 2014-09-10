package com.nateriver.app.leetcode;

/**
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null){
            first =  first.next;
            second = second.next.next;
            if(first == second)
                return true;
        }
        return false;
    }
}
