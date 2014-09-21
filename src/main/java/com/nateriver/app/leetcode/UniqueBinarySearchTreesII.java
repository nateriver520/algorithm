package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p/>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return help(1, n);
    }

    public List<TreeNode> help(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (r - l < 0) {
            res.add(null);
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> leftNodes = help(l, i - 1);
            List<TreeNode> rightNodes = help(i + 1, r);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII ut = new UniqueBinarySearchTreesII();
        System.out.println(ut.generateTrees(3));
    }
}
