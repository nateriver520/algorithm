package com.nateriver.app.cracking;

import com.nateriver.app.models.LinkNode;
import com.nateriver.app.utils.Builder;
import com.nateriver.app.utils.PrintUtil;

import java.util.HashMap;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */

public class Q21 {
    /**
     * Use a hash map to mark value
     */
    public static void removeDuplicateLink(LinkNode head){
        if(head == null || head.next == null)
            return;
        LinkNode node = head;
        HashMap<String,Integer> map = new HashMap<>();

        while (node != null && node.next != null){
            LinkNode nextNode = node.next;
            if(map.containsKey(nextNode.value)){
                //remove node
                node.next  = nextNode.next;
                nextNode.next = null;
            }
            else{
                map.put(nextNode.value,1);
            }
            node = node.next;
        }
    }

    /**
     * use two link to traverse
     * complexity would be O(n2)
     */
    public static void removeDuplicateLink1(LinkNode head){
        if(head == null || head.next == null)
            return;
        LinkNode nodeFirst = head;
        LinkNode nodeSecond;
        while (nodeFirst.next != null){
            nodeSecond = nodeFirst.next;
            while (nodeSecond != null && nodeSecond.next != null){
                LinkNode nextSecondNode = nodeSecond.next;
                if(nextSecondNode.value.equals(nodeFirst.next.value)){
                    nodeSecond.next = nextSecondNode.next;
                    nextSecondNode.next = null;
                }
                nodeSecond = nodeSecond.next;
            }

            nodeFirst = nodeFirst.next;
        }
    }

    public static void main(String[] args) {
        LinkNode head = Builder.singleLinkBuilderWithHead(new String[]{"a", "b", "c", "c", "a", "d", "a"});

        PrintUtil.printSingleLinkWithHead(head);
        removeDuplicateLink1(head);
        PrintUtil.printSingleLinkWithHead(head);

    }

}
