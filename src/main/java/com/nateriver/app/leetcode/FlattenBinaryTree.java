package com.nateriver.app.leetcode;

import com.nateriver.app.models.TreeNode;
import com.nateriver.app.utils.PrintUtil;

/**
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

      1
     / \
    2   5
   / \   \
  3   4   6

 The flattened tree should look like:
     1
      \
       2
        \
         3
          \
           4
            \
             5
              \
               6

 */
public class FlattenBinaryTree {
    public static TreeNode flatten(TreeNode root){
        if(root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = flatten(left);
        root.left = null;

        if(right == null) return root;

        TreeNode cur = root;
        while (cur.right != null){
            cur = cur.right;
        }

        cur.right = flatten(right);
        return root;
    }

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode("1");
        root.left = new TreeNode("2");
        root.right = new TreeNode("5");
        root.left.left = new TreeNode("3");
        root.left.right = new TreeNode("4");
        root.right.right = new TreeNode("6");
        PrintUtil.printTree(root);


        flatten(root);
        PrintUtil.printTree(root);
    }
}
