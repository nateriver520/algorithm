package com.nateriver.app.leetcode;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
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
            stack.push(tmp);
        }
        while (!stack.isEmpty())
            result.add(stack.pop());
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII bt = new BinaryTreeLevelOrderTraversalII();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(bt.levelOrderBottom(root));
    }
}
