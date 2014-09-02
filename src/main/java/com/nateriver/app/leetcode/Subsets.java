package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/subsets/
 * Given a set of distinct integers, S, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    HashSet<List<Integer>> hashSet = new HashSet<>();

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        calSubset(S,0, S.length,new Stack<Integer>());

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
        Subsets sub = new Subsets();
        System.out.println(sub.subsets(new int[]{1,2,3}));
        System.out.println(sub.subsets(new int[]{}));

    }
}
