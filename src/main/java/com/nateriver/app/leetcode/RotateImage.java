package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/rotate-image/
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 2 6 9     4 1 2
 1 3 5  => 7 3 6
 4 7 0     0 5 9

 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            int start = 0;
            int end = matrix.length -1;

            while (start < end){
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = tmp;
                start++;
                end--;
            }
        }

    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = new int[][]{
                {2,6,9},
                {1,3,5},
                {4,7,0}
        };
        ri.rotate(matrix);
    }

}
