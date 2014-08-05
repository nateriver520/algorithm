package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
     Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

     For example,
     If n = 4 and k = 2, a solution is:

     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]
 */
public class Combination {

    private static List<List<Integer>> numbers = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k){

        pickNumber(n, k, 1,new Stack<Integer>());
        return numbers;
    }

    public static void pickNumber(int n, int k, int cur, Stack<Integer> cache){
        if(cache.size() == k){
            List<Integer> tmp = new LinkedList<>();
            for(Integer i : cache){
                tmp.add(i);
            }
            numbers.add(tmp);
            return;
        }

        if(cur > n) return;

        cache.push(cur);
        pickNumber(n, k, cur+1, cache);
        cache.pop();
        pickNumber(n, k, cur+1, cache);
    }

    public static void main(String[] args) {
        combine(4, 2);
        for(List<Integer> list : numbers){
            System.out.println(list);
        }
    }
}
