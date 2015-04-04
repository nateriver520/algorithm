package com.nateriver.app.cracking;

import com.nateriver.app.models.LinkNode;
import com.nateriver.app.utils.Builder;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 */
public class Q22 {

    /**
     * set two point
     * second forword n than first
     * then go together
     * first will be the last n
     */
    public static LinkNode getLastN(Integer n, LinkNode head) {
        if (head == null || head.next == null)
            return null;

        LinkNode first = head;
        LinkNode second = head;

        for (int i = 0; i < n; i++) {
            if (second.next == null)
                return null;
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first;
    }


    public static void main(String[] args) {
        LinkNode head = Builder.singleLinkBuilderWithHead(new String[]{"a", "b", "c", "f", "e", "d", "a"});
        LinkNode result = getLastN(3, head);
        System.out.println("result is " + result.value);
    }
}
