package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p/>
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] minPath = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 & j == 0) {
                    minPath[i][j] = grid[i][j];
                    continue;
                }

                int xmin = i - 1 >= 0 ? minPath[i - 1][j] : Integer.MAX_VALUE;
                int ymin = j - 1 >= 0 ? minPath[i][j - 1] : Integer.MAX_VALUE;

                int min = xmin > ymin ? ymin : xmin;
                minPath[i][j] = min + grid[i][j];
            }
        }
        return minPath[n - 1][m - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum mp = new MinimumPathSum();
        System.out.println(mp.minPathSum(new int[][]{
                {1, 9, 2},
                {3, 6, 8},
                {2, 5, 1}
        }));
    }
}
