package com.nateriver.app.leetcode;


import com.nateriver.app.utils.PrintUtil;

/**
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fill(matrix, 0, 0, n, 1);
        return matrix;
    }

    public void fill(int[][] matrix, int startX, int startY, int length, int num) {
        if (length <= 0) return;

        // y direction
        for (int i = 0; i < length; i++) {
            matrix[startX][startY + i] = num++;
        }

        // x direction
        for (int i = 1; i < length; i++) {
            matrix[startX + i][startY + length - 1] = num++;
        }

        for (int i = 1; i < length; i++) {
            matrix[startX + length - 1][startY + length -1 -i] = num++;
        }

        for (int i = 1; i < length -1; i++) {
            matrix[startX+length-1 -i ][startY] = num++;
        }
        fill(matrix, startX + 1, startY + 1, length - 2, num);
    }

    public static void main(String[] args) {
        SpiralMatrixII sm = new SpiralMatrixII();
        int[][] matrix = sm.generateMatrix(5);

        PrintUtil.printMatrix(matrix);
    }

}
