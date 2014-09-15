package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/spiral-matrix/
 * Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p/>
 * For example,
 * Given the following matrix:
 * <p/>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;

        cal(0, 0, m, n, matrix);

        return res;
    }

    public void cal(int x, int y, int m, int n, int[][] matrix) {
        if (n <= 0 || m <= 0) return;
        for (int i = 0; i < n; i++)
            res.add(matrix[x][i + y]);
        for (int i = 1; i < m; i++)
            res.add(matrix[x + i][y + n - 1]);
        for (int i = 1; i < n; i++)
            if (x + m - 1 > x)
                res.add(matrix[x + m - 1][y + n - 1 - i]);
        for (int i = 1; i < m - 1; i++)
            if (x + m - 1 - i > 0 && n != 1)
                res.add(matrix[x + m - 1 - i][y]);

        cal(x + 1, y + 1, m - 2, n - 2, matrix);
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.spiralOrder(new int[][]{
                {7, 9, 6}
        }));
    }
}
