package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/combination-sum/
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
    HashSet<List<Integer>> resultSet = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(candidates, target, 0, new Stack<Integer>());
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : resultSet)
            res.add(l);

        return res;
    }

    public void findCombination(int[] candidates, int target, int idx, Stack<Integer> s) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : s) {
                tmp.add(i);
            }
            resultSet.add(tmp);
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            s.push(candidates[i]);
            findCombination(candidates, target - candidates[i], i, s);
            s.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
