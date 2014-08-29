package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle/
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        for(int i = 0; i < numRows; i++){
            List<Integer> level = new ArrayList<>();
            if(i == 0){
                level.add(1);
                result.add(level);
                continue;
            }

            if(i == 1){
                level.add(1);
                level.add(1);
                result.add(level);
                continue;
            }

            List<Integer> before = result.get(i-1);
            level.add(1);
            for(int j = 0; j < before.size() -1; j++){
                level.add(before.get(j) + before.get(j+1));
            }
            level.add(1);
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(5));
    }
}
