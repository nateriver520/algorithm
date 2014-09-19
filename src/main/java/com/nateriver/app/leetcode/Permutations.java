package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 321 213 132 312 231 123
 */
public class Permutations {
    List<List<Integer>> _res = new ArrayList<>();

    public List<List<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) return _res;
        help(num, 0);
        return _res;
    }

    public void help(int[] num, int idx) {
        if (idx == num.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : num) {
                tmp.add(i);
            }
            _res.add(tmp);
        }

        for (int i = idx; i < num.length; i++) {
            swap(num, i, idx);
            help(num, idx + 1);
            swap(num, i, idx);
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        Permutations pt = new Permutations();
        System.out.println(pt.permute(new int[]{1, 2, 3}));
    }

}
