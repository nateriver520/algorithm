package com.nateriver.app.leetcode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p/>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode nodeInCycle = findPointCycle(head);
        if (nodeInCycle == null) return null;

        ListNode start1 = head;
        ListNode start2 = nodeInCycle.next;
        int step1 = 0;
        int step2 = 0;

        while (start1 != nodeInCycle) {
            start1 = start1.next;
            step1++;
        }

        while (start2 != nodeInCycle) {
            start2 = start2.next;
            step2++;
        }

        start1 = head;
        start2 = nodeInCycle.next;

        if (step1 > step2) {
            for (int i = 0; i < step1 - step2; i++)
                start1 = start1.next;
        } else {
            for (int i = 0; i < step2 - step1; i++)
                start2 = start2.next;
        }

        while (start1 != start2) {
            start1 = start1.next;
            start2 = start2.next;
        }

        return start1;
    }

    public ListNode findPointCycle(ListNode head) {
        if (head == null) return null;
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second)
                return first;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = head.next;

        LinkedListCycleII lc = new LinkedListCycleII();
        System.out.println(lc.detectCycle(head).val);

    }
}

