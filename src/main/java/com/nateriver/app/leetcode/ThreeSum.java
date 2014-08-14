package com.nateriver.app.leetcode;

import java.util.*;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */

public class ThreeSum {
    Map<String, Integer> pairHash = new HashMap<>();

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new LinkedList<>();
        if(num == null || num.length < 3) return res;
        Arrays.sort(num);
        for(int i = 0 ; i < num.length; i++){
            int target = 0 - num[i];
            res.addAll(find2Sum(num, i, target));
        }

        return res;
    }

    public List<List<Integer>> find2Sum(int[] num, final int cur, int target){
        int min = cur +1;
        int max = num.length-1;
        List<List<Integer>> res = new LinkedList<>();
        while (min < max){
            if(min == cur) {
                min++;
                continue;
            }
            if(max == cur){
                max--;
                continue;
            }

            int sum = num[min] + num[max];
            if(sum == target){
                List<Integer> tmp = generateList(num, min, cur, max);
                String key = getKey(tmp);
                if(!pairHash.containsKey(key)){
                    res.add(tmp);
                    pairHash.put(key, 1);
                }
                min++;
                max--;
            }
            else if(sum < target)
                min++;
            else if(sum > target)
                max --;
        }
        return res;
    }

    public List<Integer> generateList(int[] num, int i, int j, int k){
        List<Integer> tmp = new LinkedList<>();
        tmp.add(num[i]);
        tmp.add(num[j]);
        tmp.add(num[k]);
        Collections.sort(tmp);
        return tmp;
    }

    public String getKey(List<Integer> res){
        return res.get(0) + "+" + res.get(1) + "+" + res.get(2);
    }

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        List<List<Integer>> res = sum.threeSum(new int[]{-1,0,1, 2, -1, -4});
        System.out.println(res);
    }
}
