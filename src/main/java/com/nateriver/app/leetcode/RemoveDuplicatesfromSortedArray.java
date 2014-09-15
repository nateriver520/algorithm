package com.nateriver.app.leetcode;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array A = [1,1,2],
 * <p/>
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int key = A[0];
        int l = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != key) {
                A[++l] = A[i];
                key = A[i];
            }
        }

        return l + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray rs = new RemoveDuplicatesfromSortedArray();
        int[] A = new int[]{1, 1, 1, 1, 1, 1};
        int idx = rs.removeDuplicates(A);
        System.out.println("idx --> " + idx);
        for (int i = 0; i < idx; i++)
            System.out.print(A[i] + " ");

    }


}
