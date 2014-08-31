package com.nateriver.app.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p/>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p/>
 * How many possible unique paths are there?
 * <p/>
 * <p/>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p/>
 * Note: m and n will be at most 100.
 */
public class UniquePaths {
    public long choose(int n, int k) {
        if (n < k)
            return 0;
        long res = 1L;
        for (int i = 1; i <= k; i++) {
            res *= n--;
            res /= i;
        }

        return res;
    }

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        int k = m > n ? n : m;
        return (int) choose(m + n - 2, k - 1);
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(1, 2));
        System.out.println(up.uniquePaths(2, 3));
        System.out.println(up.uniquePaths(1, 10)); // 1
    }
}
