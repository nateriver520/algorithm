package com.nateriver.app.leetcode;

/**
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int single = A[0];
        for(int i = 1; i < A.length; i++){
            single ^= A[i];
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(new int[]{1,1,2,3,2}));
    }
}
