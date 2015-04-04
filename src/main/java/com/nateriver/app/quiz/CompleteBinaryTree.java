package com.nateriver.app.quiz;

import com.nateriver.app.models.TreeNode;
import com.nateriver.app.utils.PrintHelper;

import java.util.LinkedList;
import java.util.Queue;


public class CompleteBinaryTree {
    private Queue<TreeNode> emptyQ = new LinkedList<>();

    public void buildQ(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (n.left == null) emptyQ.add(n);
            if (n.right == null) emptyQ.add(n);

            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    public void insert(TreeNode node) {
        TreeNode n = emptyQ.remove();
        if (n.left == null) {
            n.left = node;
        } else {
            n.right = node;
        }

        emptyQ.add(node);
        emptyQ.add(node);
    }


    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode("1");
        root.left = new TreeNode("2");
        root.right = new TreeNode("3");
        root.left.left = new TreeNode("4");
        PrintHelper.printTree(root);

        // build empty q first
        CompleteBinaryTree builder = new CompleteBinaryTree();
        builder.buildQ(root);

        // insert
        builder.insert(new TreeNode("5"));
        builder.insert(new TreeNode("6"));

        PrintHelper.printTree(root);
    }
}
