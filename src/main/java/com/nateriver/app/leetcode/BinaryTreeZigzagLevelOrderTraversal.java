package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    TreeNode one = s1.pop();
                    oneLevel.add(one.val);
                    if (one.left != null)
                        s2.push(one.left);
                    if (one.right != null)
                        s2.push(one.right);
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode one = s2.pop();
                    oneLevel.add(one.val);
                    if (one.right != null)
                        s1.push(one.right);
                    if (one.left != null)
                        s1.push(one.left);
                }
            }
            res.add(oneLevel);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.left.left = new TreeNode(99);
        root.left.right = new TreeNode(88);


        BinaryTreeZigzagLevelOrderTraversal bz = new BinaryTreeZigzagLevelOrderTraversal();

        System.out.println(bz.zigzagLevelOrder(root));
    }
}
