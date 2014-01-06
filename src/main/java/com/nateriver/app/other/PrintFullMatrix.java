package com.nateriver.app.other;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Print matrix like this
 * |1,3,4|
 * |2,3,5,6| => {1,2,4},{1,2,7},{1,2,8},{1,3,4},{1,3,7},{1,3,8} ........
 * |4,7,8|
 *
 */
public class PrintFullMatrix {
    private static void printMatrix(int[][]matrix, int start, HashMap<Integer,Integer>tempResult){

        //when reach the last row, we should print temp result
        if(matrix.length == start){
            printResult(tempResult);
            return;
        }

        for(int i = 0; i < matrix[start].length;i++){
            tempResult.put(start,matrix[start][i]);
            printMatrix(matrix, start + 1, tempResult);
        }
    }

    private static void printResult(HashMap<Integer,Integer> result){
        StringBuilder temp = new StringBuilder();
        for(Integer key : result.keySet()){
            temp.append(result.get(key)).append(" ");
        }
        System.out.println(temp.toString());

    }

    public static void printMatrix(int[][]matrix){
         HashMap<Integer,Integer> tempResult = new LinkedHashMap<Integer, Integer>();
         printMatrix(matrix,0,tempResult);
    }

    public static void main(String[] args) {
        int testcase1[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 11, 12},
                {13, 14, 15, 0}
        };

        printMatrix(testcase1);

        int testcase2[][] = {
                {1, 2, 3},
                {5, 6, 7, 8},
                {9, 0, 11, 12},
                {13, 14, 15, 0}
        };

        printMatrix(testcase2);

        int testcase3[][] = {
        };

        printMatrix(testcase3);

        int testcase4[][] = {
            {1, 2, 3}
        };

        printMatrix(testcase4);

    }


}
