package com.nateriver.app.leetcode;

import com.nateriver.app.models.LinkNode;
import com.nateriver.app.utils.Builder;
import com.nateriver.app.utils.PrintUtil;

/**
 Rotate List
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public static LinkNode rotate(LinkNode head, int n){
        if(head == null)
            return null;

        LinkNode cur = head;
        int length = 1;
        while (cur.next != null){
            cur = cur.next;
            length ++;
        }

        n = n%length;
        if(n == 0) return head;

        cur.next = head;
        LinkNode breakPoint = head;
        for(int i =0; i < length - n -1; i++){
            breakPoint = breakPoint.next;
        }

        head = breakPoint.next;
        breakPoint.next = null;
        return head;
    }

    public static void main(String[] args) {
        LinkNode head = Builder.singleLinkBuilderWithNoHead(new String[]{"1", "2", "3", "4", "5"});
        PrintUtil.printSingleLinkWithNoHead(head);

        LinkNode whead = rotate(head, 2);
        PrintUtil.printSingleLinkWithNoHead(whead);
    }
}
