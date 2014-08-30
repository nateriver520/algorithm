package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/search-a-2d-matrix/
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;

        int x = 0, y = matrix[0].length -1;
        while (x < matrix.length && y >= 0){
            int judge =  matrix[x][y];
            if(judge == target)
                return true;

            if(judge < target)
                x++;
            else
                y--;
        }
        return false;
    }

    public static void main(String[] args) {
        Searcha2DMatrix search = new Searcha2DMatrix();
        System.out.println(search.searchMatrix(new int[][]{
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        },3));
    }
}
