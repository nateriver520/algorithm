package com.nateriver.app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int cur = numbers[i];
            int need = target - cur;
            if(map.containsKey(need)){
                res[0] = map.get(need) + 1;
                res[1] = i + 1;
                return res;
            }
            else
                map.put(cur,i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] res = sum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res[0] + " " + res[1]);
    }
}
