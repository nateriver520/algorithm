package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/path-sum-ii/
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumII {
    private List<List<Integer>> paths = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        findPath(root,sum, new Stack<TreeNode>());
        return paths;
    }

    public void findPath(TreeNode root, int sum, Stack<TreeNode> s){
        if(root == null) return;
        s.push(root);
        if(root.left == null && root.right == null && (sum - root.val) == 0){
            List<Integer> temp = new ArrayList<>();
            for(TreeNode n : s){
                temp.add(n.val);
            }
            paths.add(temp);
        }

        if(root.left != null) findPath(root.left, sum - root.val, s);
        if(root.right != null) findPath(root.right, sum - root.val, s);
        s.pop();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);


        PathSumII ps = new PathSumII();
        System.out.println(ps.pathSum(root, 13));
    }
}
