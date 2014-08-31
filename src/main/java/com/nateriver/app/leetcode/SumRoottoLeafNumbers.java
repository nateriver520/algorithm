package com.nateriver.app.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRoottoLeafNumbers {
    List<String> rootToleaf = new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        generateRootToLeafString(root, "");
        int sum = 0;
        for(String val : rootToleaf){
            sum += Integer.valueOf(val);
        }
        return sum;
    }

    public void generateRootToLeafString(TreeNode root, String val){
        if(root.left == null && root.right == null){
            rootToleaf.add(val + root.val);
            return;
        }

       if(root.left != null)
           generateRootToLeafString(root.left, val + root.val);

       if(root.right != null)
           generateRootToLeafString(root.right, val + root.val);

    }

    public static void main(String[] args) {
        SumRoottoLeafNumbers sn = new SumRoottoLeafNumbers();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sn.sumNumbers(root));
    }
}
