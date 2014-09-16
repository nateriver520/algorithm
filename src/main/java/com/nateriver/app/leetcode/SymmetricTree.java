package com.nateriver.app.leetcode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <p/>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p/>
 * confused what "{1,#,2,3}" means?
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left,root.right);
    }

    public boolean check(TreeNode l, TreeNode r){
        if(l == null & r != null || l != null & r == null) return false;
        if(l == null & r == null) return true;
        if(l.val != r.val) return false;

        return check(l.left, r.right) && check(l.right, r.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(root));
    }
}
