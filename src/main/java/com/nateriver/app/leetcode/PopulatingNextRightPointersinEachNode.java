package com.nateriver.app.leetcode;

import com.nateriver.app.models.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 * <p/>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p/>
 * Initially, all next pointers are set to NULL.
 * <p/>
 * Note:
 * <p/>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q1 = new LinkedList<>();
        Queue<TreeLinkNode> q2 = new LinkedList<>();
        q1.offer(root);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            Queue<TreeLinkNode> noEmptyQ = q1.isEmpty() ? q2 : q1;
            Queue<TreeLinkNode> emptyQ = q1.isEmpty() ? q1 : q2;

            while (!noEmptyQ.isEmpty()) {
                TreeLinkNode first = noEmptyQ.poll();

                if (first.left != null)
                    emptyQ.offer(first.left);
                if (first.right != null)
                    emptyQ.offer(first.right);

                while (!noEmptyQ.isEmpty()) {
                    TreeLinkNode second = noEmptyQ.poll();
                    first.next = second;
                    if (second.left != null)
                        emptyQ.offer(second.left);
                    if (second.right != null)
                        emptyQ.offer(second.right);

                    first = second;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);

        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        PopulatingNextRightPointersinEachNode pe = new PopulatingNextRightPointersinEachNode();
        pe.connect(root);
        System.out.println("done");
    }
}
