package com.nateriver.app.leetcode;

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII {
    HashSet<List<Integer>> resultSet = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        findCombination(num, target, 0, new Stack<Integer>());
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
            findCombination(candidates, target - candidates[i], i + 1, s);
            s.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        CombinationSumII cs = new CombinationSumII();
        System.out.println(cs.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
