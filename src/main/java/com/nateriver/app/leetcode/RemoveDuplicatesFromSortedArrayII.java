package com.nateriver.app.leetcode;


/**
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A.length <= 2) return A.length;
        int[] B = new int[A.length];
        int cur = A[0];
        int count = 1;
        B[0] = cur;
        int j = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] != cur){
                cur = A[i];
                B[j++] = cur;
                count = 1;
            }
            else{
                count++;
                if(count == 2){
                    B[j++] = cur;
                }
            }
        }
        System.arraycopy(B, 0, A, 0, B.length);
        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII rm = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(rm.removeDuplicates(new int[]{1,1,1,2}));
    }
}
