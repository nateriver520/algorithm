package com.nateriver.app.leetcode;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p/>
 * Assume a BST is defined as follows:
 * <p/>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    Stack<Integer> _stack = new Stack<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean res = isValidBST(root.left);
        if (!res || !_stack.isEmpty() && root.val <= _stack.peek()) return false;
        _stack.push(root.val);
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree vt = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        System.out.println(vt.isValidBST(root));
    }
}
