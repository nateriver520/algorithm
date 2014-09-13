package com.nateriver.app.leetcode;

import com.nateriver.app.models.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {
    private Map<Integer,RandomListNode> _copyHash= new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        if(_copyHash.containsKey(head.hashCode())) return _copyHash.get(head.hashCode());

        RandomListNode copyHead = new RandomListNode(head.label);
        copyHead.next = copyRandomList(head.next);
        copyHead.random = copyRandomList(head.next);
        _copyHash.put(copyHead.hashCode(),copyHead);
        return copyHead;
    }
}
