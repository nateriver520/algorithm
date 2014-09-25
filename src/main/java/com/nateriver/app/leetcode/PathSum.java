package com.nateriver.app.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val - sum == 0) return true;
        if (root.right != null & hasPathSum(root.right, sum - root.val)) return true;
        if (root.left != null & hasPathSum(root.left, sum - root.val)) return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        PathSum ps = new PathSum();
        System.out.println(ps.hasPathSum(root, 13));

        root = TreeNode.buildTree(new String[]{"1","2","3","#","#","4","#","#","5"});
        TreeNode.print(root);
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int value) {
        this.val = value;
    }

    public static void print(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null)
                System.out.print("# ,");
            else
                System.out.print(cur.val + " ,");

            if(cur != null){
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
    }

    public static TreeNode buildTree(String[] treeVals) {
        TreeNode root = new TreeNode(Integer.valueOf(treeVals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;

        while (!q.isEmpty() && idx < treeVals.length){
            TreeNode cur = q.poll();
            String leftVal = treeVals[idx++];
            String rightVal = treeVals[idx++];

            if(!leftVal.equals("#")){
                TreeNode left = new TreeNode(Integer.valueOf(leftVal));
                cur.left = left;
                q.offer(left);
            }

            if(!rightVal.equals("#")){
                TreeNode right = new TreeNode(Integer.valueOf(rightVal));
                cur.right = right;
                q.offer(right);
            }
        }

        return root;
    }
}



