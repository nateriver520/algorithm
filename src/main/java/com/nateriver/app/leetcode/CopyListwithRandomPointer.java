package com.nateriver.app.leetcode;

import com.nateriver.app.models.RandomListNode;

/**
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {

    /**
     *  eg : copy 2 -> 3 -> 4
     *  step 1: 2 -> 2 -> 3 -> 3 -> 4 -> 4
     *  step 2: copy random
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode copyHead;
        RandomListNode cur = head;

        //copy node
        while (cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        copyHead = head.next;
        cur = head;

        //copy random link
        while (cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        //split
        while (cur != null){
            RandomListNode copy = cur.next;
            cur.next = copy.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            cur = cur.next;
        }

        return copyHead;
    }
}
