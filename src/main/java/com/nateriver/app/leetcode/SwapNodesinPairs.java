package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 Swap Nodes in Pairs Total Accepted: 21122 Total Submissions: 65068 My Submissions
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode mockHead = new ListNode(-1);
        mockHead.next = head;
        ListNode first = mockHead;
        while (first.next != null){
            ListNode second = first.next;
            if(second.next == null)
                break;
            ListNode third = second.next;
            first.next = third;
            second.next = third.next;
            third.next = second;

            first = first.next.next;
        }
        return mockHead.next;
    }

    public static void main(String[] args) {
        SwapNodesinPairs sp = new SwapNodesinPairs();
        ListNode node = ListNode.buildLink(new int[]{1,2,3,4,5});
        ListNode.print(node);
        node = sp.swapPairs(node);
        ListNode.print(node);

        node = ListNode.buildLink(new int[]{1,2});
        ListNode.print(node);
        node = sp.swapPairs(node);
        ListNode.print(node);

        node = ListNode.buildLink(new int[]{1});
        ListNode.print(node);
        node = sp.swapPairs(node);
        ListNode.print(node);


    }
}
