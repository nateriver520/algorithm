package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if(n == 1 || n == 0) return 1;
        int res = 0;
        for(int i = 1 ; i  <= n ; i++){
            res += numTrees(i -1) * numTrees(n-i);
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees ut = new UniqueBinarySearchTrees();
        System.out.println(ut.numTrees(2));
        System.out.println(ut.numTrees(3));
    }
}
