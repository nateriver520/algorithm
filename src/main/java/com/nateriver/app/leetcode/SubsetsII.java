package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/subsets-ii/
 Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetsII {
    HashSet<List<Integer>> hashSet = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        calSubset(num ,0, num.length, new Stack<Integer>());

        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l : hashSet)
            res.add(l);

        return res;
    }

    public void calSubset(int[] A, int start, int end, Stack<Integer> s) {
        if(start > end) return;

        List<Integer> temp = new ArrayList<>();
        for(Integer i : s ){
            temp.add(i);
        }
        hashSet.add(temp);

        for (int i = start; i < end; i++) {
            s.push(A[i]);
            calSubset(A, i + 1, end, s);
            s.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        SubsetsII sub = new SubsetsII();
        System.out.println(sub.subsetsWithDup(new int[]{1,2,2}));
    }
}
