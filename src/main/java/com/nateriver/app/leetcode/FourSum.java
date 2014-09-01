package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/4sum/
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p/>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p/>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class FourSum {
    HashSet<List<Integer>> resultSet = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int t = target - num[i] - num[j];
                find2Sum(num, i, j, j+1, num.length -1, t);
            }
        }

        for(List<Integer> l : resultSet){
            result.add(l);
        }

        return result;
    }

    public void find2Sum(int[] num, int i, int j, int l, int r, int target) {
        while (l < r) {
            int sum = num[l] + num[r];
            if (sum < target)
                l++;
            else if (sum > target)
                r--;
            else {
                //find one
                List<Integer> one = new ArrayList<>();
                one.add(num[i]);
                one.add(num[j]);
                one.add(num[l]);
                one.add(num[r]);
                resultSet.add(one);
                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }
}
