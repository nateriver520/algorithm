package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/search-for-a-range/
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0;
        int r = A.length - 1;
        int find = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == A[mid]) {
                find = mid;
                break;
            } else if (target < A[mid])
                r--;
            else
                l++;
        }

        int rloc = find;
        int lloc = find;

        if(find != -1){
            while (rloc < A.length && A[rloc] == target)
                rloc++;
            res[1] = rloc -1;

            while (lloc >= 0 && A[lloc] == target)
                lloc--;
            res[0] = lloc + 1;
        }

        return res;
    }

    public static void printRes(int[] res){
        System.out.println(String.format("[%s,%s]",res[0],res[1]));
    }

    public static void main(String[] args) {
        SearchForARange sr = new SearchForARange();
        SearchForARange.printRes(sr.searchRange(new int[]{5, 7, 7, 8, 8, 10},8));
        SearchForARange.printRes(sr.searchRange(new int[]{5, 7, 7, 7, 8, 10},7));
        SearchForARange.printRes(sr.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 12));
        SearchForARange.printRes(sr.searchRange(new int[]{9,12}, 12));


    }
}
