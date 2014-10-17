package com.nateriver.app.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p/>
 * Find the minimum element.
 * <p/>
 * You may assume no duplicate exists in the array.
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return 0;
        int l = 0, r = num.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (num[mid] < num[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return num[l];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fa = new FindMinimumInRotatedSortedArray();
        System.out.println(fa.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(fa.findMin(new int[]{2, 4, 5, 6, 7, -1, 1}));
        System.out.println(fa.findMin(new int[]{2}));
        System.out.println(fa.findMin(new int[]{1, 2}));
        System.out.println(fa.findMin(new int[]{2, 1}));

    }
}
