package com.nateriver.app.leetcode;


/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null){
            if(cur.val != next.val){
                cur = cur.next;
                next = next.next;
            }
            else{
                cur.next = next.next;
                next.next = null;
                next = cur.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.buildLink(new int[]{1});
        ListNode.print(head);

        RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
        head = rd.deleteDuplicates(head);
        ListNode.print(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode buildLink(int[] vals){
        ListNode head = new ListNode(vals[0]);
        ListNode node = head;
        for(int i= 1; i< vals.length; i++){
            node.next = new ListNode(vals[i]);
            node = node.next;
            node.next = null;
        }
        return head;
    }

    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " =>");
            head = head.next;
        }
        System.out.println();
    }
}
