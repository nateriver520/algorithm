package com.nateriver.app.leetcode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p/>
 * Recover the tree without changing its structure.
 * <p/>
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * confused what "{1,#,2,3}" means?
 */
public class RecoverBinarySearchTree {
    TreeNode first;
    TreeNode second;
    TreeNode pre;


    public void recoverTree(TreeNode root) {
        findMistakeNode(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void findMistakeNode(TreeNode cur) {
        if (cur == null) return;
        findMistakeNode(cur.left);
        if(pre != null && cur.val < pre.val) {
            if(first == null)
                first = pre;
            second = cur;
        }

        pre = cur;
        findMistakeNode(cur.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree rt = new RecoverBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(9);

        rt.recoverTree(root);
        System.out.println("done");
    }


}
