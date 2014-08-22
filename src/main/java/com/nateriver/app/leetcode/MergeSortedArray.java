package com.nateriver.app.leetcode;

/**
 Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note:
 You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = m -1,j = n -1, k = m + n - 1;

        while (i >= 0 & j >= 0){
            if(A[i] > B[j])
                A[k--] = A[i--];
            else if(A[i] == B[j]){
                A[k--] = A[i--];
                A[k--] = B[j--];
            }
            else
                A[k--] = B[j--];
        }

        while (j >= 0){
            A[k--] = B[j--];
        }
    }

    public static void main(String[] args) throws Exception {
        MergeSortedArray ms = new MergeSortedArray();
        int[] A = new int[10];
        int[] B = new int[]{1,3,10};
        ms.merge(A,0,B,3);
    }
}
