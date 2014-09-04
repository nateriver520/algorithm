package com.nateriver.app.leetcode;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/3sum-closest/
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p/>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p/>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int closestSumOfThree = -1;
        for (int i = 0; i < num.length - 2; i++) {
            int sumOfTwo = findClosest(num, i + 1, num.length - 1, target - num[i]);
            int sumOfThree = sumOfTwo + num[i];
            int judge = Math.abs(sumOfThree - target);
            if (judge == 0) return sumOfThree;
            if (judge < min) {
                min = judge;
                closestSumOfThree = sumOfThree;
            }
        }
        return closestSumOfThree;
    }

    public int findClosest(int[] num, int l, int r, int target) {
        int min = Integer.MAX_VALUE;
        int closestSumOfTwo = -1;
        while (l < r) {
            int judge = num[l] + num[r];
            if (judge == target) return target;
            if (judge < target)
                l++;
            else
                r--;
            if (Math.abs(target - judge) < min) {
                min = Math.abs(target - judge);
                closestSumOfTwo = judge;
            }
        }
        return closestSumOfTwo;
    }

    public static void main(String[] args) {
        ThreeSumClosest ts = new ThreeSumClosest();
        System.out.println(ts.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(ts.threeSumClosest(new int[]{-1, 2, 1, -4}, 2));
        System.out.println(ts.threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(ts.threeSumClosest(new int[]{0, 1, 2}, 3));

    }

}
