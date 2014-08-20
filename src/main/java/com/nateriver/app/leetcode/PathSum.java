package com.nateriver.app.leetcode;


/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val - sum == 0) return true;
        if(root.right != null & hasPathSum(root.right, sum - root.val) ) return true;
        if(root.left != null & hasPathSum(root.left,sum - root.val) ) return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        PathSum ps = new PathSum();
        System.out.println(ps.hasPathSum(root, 13));
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int value) {
        this.val = value;
    }
}



