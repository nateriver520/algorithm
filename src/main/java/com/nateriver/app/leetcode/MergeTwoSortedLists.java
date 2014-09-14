package com.nateriver.app.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mockHead1 = new ListNode(-1);
        ListNode mockHead2 = new ListNode(-1);

        mockHead1.next = l1;
        mockHead2.next = l2;
        l1 = mockHead1;
        l2 = mockHead2;

        while (l1.next != null && l2.next != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            if (next1.val >= next2.val) {
                l1.next = next2;
                l2.next = next2.next;
                next2.next = next1;
            }
            l1 = l1.next;
        }

        if (l2.next != null) {
            l1.next = l2.next;
            l2.next = null;
        }
        return mockHead1.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists ml = new MergeTwoSortedLists();
        ListNode head1 = ListNode.buildLink(new int[]{1, 3, 5});
        ListNode head2 = ListNode.buildLink(new int[]{0, 2, 3, 6, 9});
        ListNode.print(ml.mergeTwoLists(head1, head2));
    }
}
