package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> noEmptyQ = q1.isEmpty()? q2 :q1;
            Queue<TreeNode> emptyQ =   q1.isEmpty()? q1 :q2;

            while (!noEmptyQ.isEmpty()){
                TreeNode cur = noEmptyQ.poll();
                tmp.add(cur.val);
                if (cur.left != null)
                    emptyQ.offer(cur.left);
                if (cur.right != null)
                    emptyQ.offer(cur.right);
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal bt = new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(bt.levelOrder(root));
    }
}
