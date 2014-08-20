package com.nateriver.app.leetcode;

/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int sum = -1;
        int maxSum = Integer.MIN_VALUE;
        for (int a : A) {
            if (sum < 0)
                sum = a;
            else
                sum += a;

            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

    public static void main(String[] args) throws Exception {
        MaximumSubarray sb = new MaximumSubarray();
        System.out.println(sb.maxSubArray(new int[]{-2}));
    }
}
