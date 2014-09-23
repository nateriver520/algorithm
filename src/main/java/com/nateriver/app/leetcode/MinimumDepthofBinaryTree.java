package com.nateriver.app.leetcode;

/**
 * Given a binary tree, find its minimum depth.
 * <p/>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);

        if (leftMin == 0)
            return rightMin + 1;
        else if (rightMin == 0)
            return leftMin + 1;
        else
            return Math.min(leftMin, rightMin) + 1;
    }
}
