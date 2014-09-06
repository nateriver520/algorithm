package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p/>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).      2 4 5 6 7 0 1     7 0 1 2 4 5 6
 * <p/>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p/>
 * You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) return mid;

            //left is sort
            if(A[mid] >= A[l]){
                if(target < A[mid] && target >= A[l])
                    r = mid -1;
                else
                    l = mid + 1;
            }
            else {
                if(target > A[mid] & target <= A[r])
                    l = mid +1;
                else
                    r = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray ss = new SearchinRotatedSortedArray();
        System.out.println(ss.search(new int[]{4,5,6,7,0,1,2}, 1));
        System.out.println(ss.search(new int[]{1}, 1));
        System.out.println(ss.search(new int[]{3,1}, 1));

    }
}
