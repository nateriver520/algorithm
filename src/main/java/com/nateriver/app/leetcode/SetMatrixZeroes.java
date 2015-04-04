package com.nateriver.app.leetcode;

import com.nateriver.app.utils.PrintHelper;

/**
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p/>
 * click to show follow up.
 * <p/>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;

        boolean isFirstColSetToZero = false;
        boolean isFirstRowSetToZero = false;


        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColSetToZero = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowSetToZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;
            }
        }


        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++)
                    matrix[j][i] = 0;
            }
        }

        if (isFirstRowSetToZero)
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;

        if (isFirstColSetToZero)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;

    }

    public static void main(String[] args) throws Exception {
        SetMatrixZeroes sz = new SetMatrixZeroes();
        int[][] m = new int[][]{
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        };
        sz.setZeroes(m);
        System.out.println();
        PrintHelper.printMatrix(m);
    }
}
