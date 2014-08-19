package com.nateriver.app.leetcode;

/**
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;

        // remove duplicate head
        boolean isDuplicateHead = false;
        int val = head.val;
        while (next != null){
            if(next.val == val){
                next = next.next;
                isDuplicateHead = true;
            }
            else if(isDuplicateHead && next.next != null && next.val == next.next.val){
                val = next.val;
                next = next.next;
            }
            else
                break;
        }

        if(isDuplicateHead){
            head = next;
        }
        ListNode cur = head;

        if(head == null) return null;

        next = head.next;


        while (next != null && next.next!= null){
            ListNode nextnext = next.next;
            if(next.val != nextnext.val){
                next = next.next;
            }
            else{
                //find first is none duplicate
                nextnext = nextnext.next;
                while (nextnext != null && nextnext.val == next.val)
                    nextnext = nextnext.next;
                while (cur.next != next)
                    cur = cur.next;
                cur.next = nextnext;
                next = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildLink(new int[]{1,1,2});
        ListNode.print(head);

        RemoveDuplicatesFromSortedListII rd = new RemoveDuplicatesFromSortedListII();
        head = rd.deleteDuplicates(head);
        ListNode.print(head);
    }
}

