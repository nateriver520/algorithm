package com.nateriver.app.cracking;

import com.nateriver.app.utils.PrintUtil;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 */
public class Q17 {
    /**
     * use two boolen array to record the 0 factor position
     * first traverse to find the zero, and set mark array
     * second traverse to set the number to zero
     */
    public static Integer[][] zero(Integer[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] mark_m = new boolean[m];
        boolean[] mark_n = new boolean[n];

        for(int i = 0; i< m ; i++ ) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    mark_m[i] = true;
                    mark_n[j] = true;
                }
            }
        }

        for(int i = 0; i< m ; i++ ) {
            for(int j = 0; j < n; j++) {
                if(mark_m[i] || mark_n[j]){
                    matrix[i][j] =0;
                }
            }
        }

        return matrix;

    }

    public static void main(String[] args) {

        Integer testcase1[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 0, 11, 12},
            {13, 14, 15, 0}
        };

        PrintUtil.printMatrix(zero(testcase1));

    }


}
