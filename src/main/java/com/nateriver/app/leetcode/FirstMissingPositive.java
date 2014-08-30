package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int miss = A.length + 1;
        for (int i = 0; i < A.length; ) {
            if (A[i] > 0 && i + 1 != A[i] && A[i] -1 < A.length && A[A[i] -1] != A[i]) {
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            } else
                i++;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1){
                miss = i + 1;
                break;
            }
        }

        return miss;
    }

    public static void main(String[] args) throws Exception {
        FirstMissingPositive fp = new FirstMissingPositive();
        System.out.println(fp.firstMissingPositive(new int[]{1,2,0}));    // 3
        System.out.println(fp.firstMissingPositive(new int[]{3,4,-1,1})); // 2
        System.out.println(fp.firstMissingPositive(new int[]{2}));        // 1
        System.out.println(fp.firstMissingPositive(new int[]{1,1}));      // 2
        System.out.println(fp.firstMissingPositive(new int[]{}));         // 1
        System.out.println(fp.firstMissingPositive(new int[]{1}));        // 2
        System.out.println(fp.firstMissingPositive(new int[]{1000,-1}));  // 1

    }
}
