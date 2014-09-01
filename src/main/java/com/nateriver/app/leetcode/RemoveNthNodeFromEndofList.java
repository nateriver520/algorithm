package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p/>
 * For example,
 * <p/>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p/>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode mockHead = new ListNode(-1);
        mockHead.next = head;

        ListNode cur = mockHead;
        ListNode curnext = mockHead;

        for (int i = 0; i < n; i++) {
            if (curnext.next == null)
                return mockHead.next;
            else
                curnext = curnext.next;
        }

        // go to end
        while (curnext.next != null){
            curnext = curnext.next;
            cur = cur.next;
        }

        ListNode next = cur.next;
        cur.next = next.next;
        next.next = null;

        return mockHead.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList rl = new RemoveNthNodeFromEndofList();

        ListNode node = ListNode.buildLink(new int[]{1,2,3,4,5});
        ListNode.print(node);
        ListNode.print(rl.removeNthFromEnd(node,2));

        node = ListNode.buildLink(new int[]{1,2});
        ListNode.print(node);
        ListNode.print(rl.removeNthFromEnd(node,2));

        node = ListNode.buildLink(new int[]{1});
        ListNode.print(node);
        ListNode.print(rl.removeNthFromEnd(node,1));

    }
}
