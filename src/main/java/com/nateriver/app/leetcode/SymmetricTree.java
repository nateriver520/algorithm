package com.nateriver.app.leetcode;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        preLOrder(root.left, l1);
        preROrder(root.right, r1);

        llOrder(root.left, l2);
        rrOrder(root.right, r2);
        return l1.equals(r1) && l2.equals(r2);
    }

    public void preLOrder(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        l.add(root.val);
        preLOrder(root.left, l);
        preLOrder(root.right, l);
    }

    public void preROrder(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        l.add(root.val);
        preROrder(root.right, l);
        preROrder(root.left, l);
    }

    public void llOrder(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        llOrder(root.left, l);
        l.add(root.val);
        llOrder(root.right, l);
    }

    public void rrOrder(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        rrOrder(root.right, l);
        l.add(root.val);
        rrOrder(root.left, l);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(root));
    }
}
