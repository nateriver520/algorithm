package com.nateriver.app.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p/>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalanced(root.left)
               && isBalanced(root.right)
               && Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) <= 1;
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;
    }
}
