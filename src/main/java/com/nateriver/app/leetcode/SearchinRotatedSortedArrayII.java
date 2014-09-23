package com.nateriver.app.leetcode;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p/>
 * Would this affect the run-time complexity? How and why?
 * <p/>
 * Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        return cal(A, target, 0, A.length - 1);
    }

    public boolean cal(int[] A, int target, int l, int r) {
        if (l > r) return false;
        int mid = (l + r) / 2;
        if (target == A[mid]) return true;

        //reach duplicate point
        if (A[l] == A[mid] && A[r] == A[mid])
            return cal(A, target, l + 1, mid - 1) || cal(A, target, mid + 1, r - 1);

        if (A[mid] >= A[l]) {
            if (target < A[mid] && target >= A[l])
                return cal(A, target, l, mid - 1);
            else
                return cal(A, target, mid + 1, r);
        } else {
            if (target > A[mid] & target <= A[r])
                return cal(A, target, mid + 1, r);
            else
                return cal(A, target, l, mid - 1);
        }
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayII si = new SearchinRotatedSortedArrayII();
        System.out.println(si.search(new int[]{1, 3, 1, 1, 1}, 3));
    }
}
