package com.nateriver.app.leetcode;

/**
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length ==0) return 0;
        int start = 0;
        int end = A.length -1;
        int orgLen = A.length;
        while (start <= end){
            if(A[end] == elem){
                end --;
                orgLen--;
            } else if(A[start] != elem )
                start++;
            else {
                A[start++] = A[end--];
                orgLen--;
            }
        }
        return orgLen;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[]{0,4,4,0,4,4,4,0,2}, 4));
        System.out.println(re.removeElement(new int[]{2, 2, 2, 2, 2}, 2));
        System.out.println(re.removeElement(new int[]{1, 1, 1, 1, 2}, 2));

    }
}
