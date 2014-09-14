package com.nateriver.app.leetcode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return convert(num, 0, num.length - 1);
    }

    public TreeNode convert(int[] num, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = convert(num, l, mid - 1);
        node.right = convert(num, mid + 1, r);
        return node;
    }

    public static void main(String[] args) throws Exception {

    }
}
