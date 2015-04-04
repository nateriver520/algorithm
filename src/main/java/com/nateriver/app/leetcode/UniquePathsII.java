package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/unique-paths-ii/
 * Follow up for "Unique Paths":
 * <p/>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p/>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p/>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p/>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p/>
 * Note: m and n will be at most 100.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] uniqPaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    uniqPaths[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    uniqPaths[i][j] = 1;
                    continue;
                }

                if (i == 0)
                    uniqPaths[i][j] = uniqPaths[i][j - 1];
                else if (j == 0)
                    uniqPaths[i][j] = uniqPaths[i - 1][j];
                else {
                    uniqPaths[i][j] = uniqPaths[i - 1][j] + uniqPaths[i][j - 1];
                }
            }
        }
        return uniqPaths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII up = new UniquePathsII();
        System.out.println(up.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));

        System.out.println(up.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));

        System.out.println(up.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 1, 0}
        }));

        System.out.println(up.uniquePathsWithObstacles(new int[][]{
                {0, 1, 0}
        }));
    }
}
