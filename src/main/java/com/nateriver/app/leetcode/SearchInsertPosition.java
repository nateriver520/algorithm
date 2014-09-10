package com.nateriver.app.leetcode;

/**
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int l = 0;
        int r = A.length -1;
        int mid;
        while (l <= r){
            mid = (l + r)/2;
            if(A[mid] == target)
                return mid;
            if(A[mid] > target)
                r = mid -1;
            else
                l = mid +1;
        }
        return l;
    }

    public static void main(String[] args) {
        SearchInsertPosition sp = new SearchInsertPosition();
        System.out.println(sp.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(sp.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(sp.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(sp.searchInsert(new int[]{1,3,5,6},0));
    }
}
