package com.nateriver.app.leetcode;

import com.nateriver.app.models.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
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
}
