package com.nateriver.app.leetcode;

/**
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * Given a binary tree, find the maximum path sum.
 * <p/>
 * The path may start and end at any node in the tree.
 * <p/>
 * For example:
 * Given the below binary tree,
 * <p/>
 * 1
 * / \
 * 2   3
 * Return 6.
 */
public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calMaxPathSum(root, -1);
        return max;
    }

    public int calMaxPathSum(TreeNode root, int sum) {
        if (root == null) return sum;

        int leftSum = calMaxPathSum(root.left, sum);
        int rightSum = calMaxPathSum(root.right, sum);

        if (sum < 0)
            sum = root.val;

        int maxSumWithCurNode = root.val;

        if (rightSum > 0)
            maxSumWithCurNode += rightSum;

        if (leftSum > 0)
            maxSumWithCurNode += leftSum;


        if (leftSum > rightSum && leftSum > 0)
            sum += leftSum;
        else if (leftSum <= rightSum && rightSum > 0)
            sum += rightSum;

        if (maxSumWithCurNode > max)
            max = maxSumWithCurNode;

        return sum;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum bs = new BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        System.out.println(bs.maxPathSum(root));
    }

}
